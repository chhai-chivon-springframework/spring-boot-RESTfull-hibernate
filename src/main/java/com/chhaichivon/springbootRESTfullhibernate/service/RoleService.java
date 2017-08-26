package com.chhaichivon.springbootRESTfullhibernate.service;

import com.chhaichivon.springbootRESTfullhibernate.models.Role;
import com.chhaichivon.springbootRESTfullhibernate.repository.RoleRepository;
import com.chhaichivon.springbootRESTfullhibernate.utils.BaseServiceHelper;
import com.chhaichivon.springbootRESTfullhibernate.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chhaichivon on 8/26/17.
 */
@Service
public class RoleService implements BaseServiceHelper<Role>{

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role findById(long id) {
		return roleRepository.findById(id);
	}

	@Override
	public Boolean save(Role entity) {
		return roleRepository.save(entity);
	}

	@Override
	public Boolean update(Role entity) {
		return roleRepository.update(entity);
	}

	@Override
	public Boolean delete(Long id) {
		return roleRepository.delete(id);
	}

	@Override
	public List<Role> get(Pagination pagination) {
		return roleRepository.get(pagination);
	}
}
