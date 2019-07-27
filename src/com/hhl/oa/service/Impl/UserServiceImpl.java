package com.hhl.oa.service.Impl;

import com.hhl.oa.base.DaoSupportImpl;
import com.hhl.oa.domian.User;
import com.hhl.oa.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService {


    @Override
    public User findByLogin(String logName, String password) {
        String md5Digest = DigestUtils.md5DigestAsHex(password.getBytes());
        User user = (User) getSession().createQuery("from User u where u.loginName = ?0 and u.password = ?1")
                .setParameter(0, logName).setParameter(1, md5Digest).uniqueResult();
        return user;
    }
}
