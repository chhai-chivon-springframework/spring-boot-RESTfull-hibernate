package com.chhaichivon.springbootRESTfullhibernate.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/26/2017
 * TIME   : 2:17 PM
 */
public abstract class BaseController<T> {
    public static final String MESSAGE_SUCCESS = "SUCCESS";
    public static final String MESSAGE_FAILURE = "FAIL";
    private Map<String, Object> map = new HashMap<>();

    private Map<String, Object> mapJson(T object, HttpStatus status, String message) {
        if(object != null){
            map.put("DATA", object);
            map.put("STATUS", status);
            map.put("MESSAGE", message);
        }else{
            map.put("STATUS", status);
            map.put("MESSAGE", message);
        }
        return map;
    }

    public ResponseEntity<Map<String, Object>> responseJson(T object, HttpStatus httpStatus) {
        if (object != null) {
            map = mapJson(object, HttpStatus.OK, MESSAGE_SUCCESS);
        } else {
            map = mapJson(null, HttpStatus.NOT_FOUND, MESSAGE_FAILURE);
        }
        return new ResponseEntity<>(map, httpStatus);
    }

    public ResponseEntity<Map<String, Object>> responseJson(List<T> objects, HttpStatus httpStatus) {
        if (!objects.isEmpty()) {
            map = mapJson((T) objects, HttpStatus.OK, MESSAGE_SUCCESS);
        } else {
            map = mapJson(null, HttpStatus.NOT_FOUND, MESSAGE_FAILURE);
        }
        return new ResponseEntity<>(map, httpStatus);
    }
}
