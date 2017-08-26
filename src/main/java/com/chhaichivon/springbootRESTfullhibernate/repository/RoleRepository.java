package com.chhaichivon.springbootRESTfullhibernate.repository;

import com.chhaichivon.springbootRESTfullhibernate.models.Role;
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
 * Created by chhaichivon on 8/26/17.
 */
@Repository
public class RoleRepository implements BaseServiceHelper<Role>{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Role findById(long id) {
		try{
			return sessionFactory.getCurrentSession().get(Role.class,id);
		}catch (Exception e){

		}
		return null;
	}

	@Override
	@Transactional
	public Boolean save(Role entity) {
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
	public Boolean update(Role entity) {
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
			Role role = sessionFactory.getCurrentSession().load(Role.class, id);
			if (role != null) {
				sessionFactory.getCurrentSession().delete(role);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional
	public List<Role> get(Pagination pagination) {
		try{
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Role.class);
			criteria.setFirstResult(pagination.offset());
			criteria.setMaxResults(pagination.getLimit());
			List<Role> roles= (List<Role>)criteria.list();
			return roles;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
