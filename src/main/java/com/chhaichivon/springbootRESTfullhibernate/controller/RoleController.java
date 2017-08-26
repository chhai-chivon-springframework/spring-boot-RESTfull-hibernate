package com.chhaichivon.springbootRESTfullhibernate.controller;

import com.chhaichivon.springbootRESTfullhibernate.form.RoleForm;
import com.chhaichivon.springbootRESTfullhibernate.models.Role;
import com.chhaichivon.springbootRESTfullhibernate.service.RoleService;
import com.chhaichivon.springbootRESTfullhibernate.utils.BaseController;
import com.chhaichivon.springbootRESTfullhibernate.utils.Pagination;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chhaichivon on 8/26/17.
 */
@RestController
@Api(basePath = "/api", value = "Roles", description = "Operations with roles", produces = "application/json")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoleController extends BaseController<Role> {

	@Autowired
	private RoleService roleService;
	public Map<String, Object> map;

	@RequestMapping(value = "/roles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Map<String, Object>> findAll(
			@RequestParam(value ="page", required = false , defaultValue="1") int page,
			@RequestParam(value ="limit", required = false , defaultValue="15") int limit) {
		map = new HashMap<>();
		List<Role> roles = null;
		Pagination pagination = new Pagination();
		pagination.setPage(page);
		pagination.setLimit(limit);
		try {
			roles = roleService.get(pagination);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("Error" + e.getMessage());
		}
		return responseJson(roles, HttpStatus.OK);
	}

	@RequestMapping(value = "/roles/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
		map = new HashMap<>();
		Role role = null;
		try {
			role = roleService.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseJson(role, HttpStatus.OK);
	}


	@RequestMapping(value = "/roles", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Map<String, Object>> save(@RequestBody RoleForm roleForm) {
		map = new HashMap<>();
		Role role = new Role();
		try {
			if (roleForm != null) {
				role.setRoleName(roleForm.getRoleName());
			}
			roleService.save(role);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseJson(role, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/roles", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Map<String, Object>> update(@RequestBody Role roleUpdate) {
		map = new HashMap<>();
		try {
			if (roleUpdate != null) {
				roleService.update(roleUpdate);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return responseJson(roleUpdate, HttpStatus.OK);
	}

	@RequestMapping(value = "/roles/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") long id) {
		map = new HashMap<>();
		Role role = roleService.findById(id);
		try {
			roleService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseJson(role, HttpStatus.OK);
	}
}