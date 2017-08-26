package com.chhaichivon.springbootRESTfullhibernate.controller;

import com.chhaichivon.springbootRESTfullhibernate.form.UserForm;
import com.chhaichivon.springbootRESTfullhibernate.models.User;
import com.chhaichivon.springbootRESTfullhibernate.service.UserService;
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
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/26/2017
 * TIME   : 12:49 PM
 */
@RestController
@Api(basePath = "/api", value = "Users", description = "Operations with users", produces = "application/json")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController extends BaseController<User> {

    @Autowired
    private UserService userService;
    public Map<String, Object> map;

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> findAll(
            @RequestParam(value ="page", required = false , defaultValue="1") int page,
            @RequestParam(value ="limit", required = false , defaultValue="15") int limit) {
        map = new HashMap<>();
        List<User> users = null;
        Pagination pagination = new Pagination();
        pagination.setPage(page);
        pagination.setLimit(limit);
        try {
            users = userService.get(pagination);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Error" + e.getMessage());
        }
        return responseJson(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        map = new HashMap<>();
        User user = null;
        try {
            user = userService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(user, HttpStatus.OK);
    }


    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> save(@RequestBody UserForm userForm) {
        map = new HashMap<>();
        User user = new User();
        try {
            if (userForm != null) {
                user.setUsername(userForm.getUserName());
                user.setEmail(userForm.getEmail());
                user.setPassword(userForm.getPassword());
            }
            userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(user, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> update(@RequestBody User userUpdate) {
        map = new HashMap<>();
        try {
            if (userUpdate != null) {
                userService.update(userUpdate);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        return responseJson(userUpdate, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") long id) {
        map = new HashMap<>();
        User user = userService.findById(id);
        try {
                userService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(user, HttpStatus.OK);
    }
}