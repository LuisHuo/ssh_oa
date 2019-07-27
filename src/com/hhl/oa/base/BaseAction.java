package com.hhl.oa.base;

import com.hhl.oa.service.*;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
    protected T model;

    @Resource
    protected DepartmentService departmentService;

    @Resource
    protected RoleService roleService;

    @Resource
    protected UserService userService;

    @Resource
    protected PrivilegeService privilegeService;

    @Resource
    protected ForumManageService forumManageService;


    public BaseAction(){
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
        try {
            model = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T getModel() {
        return model;
    }
}
