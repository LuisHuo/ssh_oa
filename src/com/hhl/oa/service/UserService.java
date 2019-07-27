package com.hhl.oa.service;

import com.hhl.oa.base.DaoSupport;
import com.hhl.oa.domian.User;

public interface UserService extends DaoSupport<User> {

    User findByLogin(String logName, String password);
}

