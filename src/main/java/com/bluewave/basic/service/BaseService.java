package com.bluewave.basic.service;

import java.io.Serializable;
import java.util.List;

/**
 * 通用CRUD服务接口
 *2015/3/28.
 */
public interface BaseService<T, ID extends Serializable>{

    /**
     * 保存
     *
     * @param entity
     */
    <S extends T> S save(S entity);

    /**
     * 批量保存
     *
     * @param entities
     * @param <S>
     * @return
     */
    <S extends T> Iterable<S> save(Iterable<S> entities);

    /**
     * 通过ID删除
     *
     * @param id
     */
    void delete(ID id);

    /**
     * 删除实体
     *
     * @param entity
     */
    void delete(T entity);

    /**
     * 通过ID批量删除
     *
     * @param ids
     */
    void delete(Iterable<ID> ids);
    /**
     * 通过ID查找
     *
     * @param id
     * @return
     */
    T findById(ID id);
    
    /**
     * 查询所有
     *
     * @return
     */
    List<T> findAll();


}
