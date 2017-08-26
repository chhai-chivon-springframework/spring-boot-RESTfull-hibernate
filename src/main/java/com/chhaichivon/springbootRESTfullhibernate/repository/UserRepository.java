package com.chhaichivon.springbootRESTfullhibernate.repository;

import com.chhaichivon.springbootRESTfullhibernate.models.User;
import com.chhaichivon.springbootRESTfullhibernate.utils.BaseServiceHelper;
import com.chhaichivon.springbootRESTfullhibernate.utils.Pagination;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/26/2017
 * TIME   : 12:50 PM
 */
@Repository
public class UserRepository implements BaseServiceHelper<User> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public User findById(long id) {
        try{
            return sessionFactory.getCurrentSession().get(User.class,id);
        }catch (Exception e){

        }
        return null;
    }

    @Override
    @Transactional
    public Boolean save(User entity) {
        try{
            sessionFactory.getCurrentSession().saveOrUpdate(entity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean update(User entity) {
        try{
            sessionFactory.getCurrentSession().saveOrUpdate(entity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        try {
            User user = sessionFactory.getCurrentSession().load(User.class, id);
            if (user != null) {
                sessionFactory.getCurrentSession().delete(user);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public List<User> get(Pagination pagination) {
        try{
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
            criteria.setFirstResult(pagination.offset());
            criteria.setMaxResults(pagination.getLimit());
            List<User> users= (List<User>)criteria.list();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
