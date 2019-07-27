package com.hhl.oa.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

@Transactional
public class DaoSupportImpl<E> implements DaoSupport<E> {

    @Resource
    private SessionFactory sessionFactory;
    private Class<E> clazz;

    public DaoSupportImpl(){
        //获取当前new的对象的泛型的父类类型
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class<E>) pt.getActualTypeArguments()[0];
    }

    //获取当前可用的Session对象
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(E entity) {
        getSession().save(entity);
    }

    @Override
    public void delete(Long id) {
        Object obj = getById(id);
        if (null != obj){
            getSession().delete(obj);
        }
    }

    @Override
    public void update(E entity) {
        getSession().update(entity);
    }

    @Override
    public E getById(Long id) {
        if (null == id) {
            return null;
        } else {
            return (E) getSession().get(clazz, id);
        }
    }

    @Override
    public List<E> getByIds(Long[] ids) {
        if (null == ids || 0 == ids.length){
            return Collections.EMPTY_LIST;
        }else {
            return getSession().createQuery(
                    "from " + clazz.getSimpleName() + " where id in (:ids)"
            ).setParameterList("ids", ids)
                    .list();
        }

    }

    @Override
    public List<E> findAll() {
        return getSession().createQuery(
                "FROM  " + clazz.getSimpleName()).
                list();
    }
}
