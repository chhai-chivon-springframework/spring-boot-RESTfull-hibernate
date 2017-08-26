package com.chhaichivon.springbootRESTfullhibernate.utils;

import java.util.List;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/26/2017
 * TIME   : 12:53 PM
 */
public interface BaseServiceHelper<T> {
    public T findById(long id);
    public Boolean save(T entity);
    public Boolean update(T entity);
    public Boolean delete(Long id);
    public List<T> get(Pagination pagination);
}
