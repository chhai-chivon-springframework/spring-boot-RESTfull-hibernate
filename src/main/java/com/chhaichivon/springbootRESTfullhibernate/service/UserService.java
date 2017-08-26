package com.chhaichivon.springbootRESTfullhibernate.service;

import com.chhaichivon.springbootRESTfullhibernate.models.User;
import com.chhaichivon.springbootRESTfullhibernate.repository.UserRepository;
import com.chhaichivon.springbootRESTfullhibernate.utils.BaseServiceHelper;
import com.chhaichivon.springbootRESTfullhibernate.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/26/2017
 * TIME   : 12:50 PM
 */
@Service
public class UserService implements BaseServiceHelper<User> {

    @Autowired
    private UserRepository  userRepository;

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Boolean save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public Boolean update(User entity) {
        return userRepository.update(entity);
    }

    @Override
    public Boolean delete(Long id) {
        return userRepository.delete(id);
    }

    @Override
    public List<User> get(Pagination pagination) {
        return userRepository.get(pagination);
    }
}
