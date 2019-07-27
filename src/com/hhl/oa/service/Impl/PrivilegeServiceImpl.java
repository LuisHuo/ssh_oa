package com.hhl.oa.service.Impl;

import com.hhl.oa.base.DaoSupportImpl;
import com.hhl.oa.domian.Privilege;
import com.hhl.oa.service.PrivilegeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege> implements PrivilegeService {

    @Override
    public List<Privilege> findTopList() {
        List<Privilege> topPrivilegeList = getSession()
                .createQuery("FROM Privilege p where p.parent is null ")
                .list();
        return topPrivilegeList;
    }

    @Override
    public Collection<String> getAllPrivilegeUrls() {
        return getSession().createQuery("select distinct p.url FROM Privilege p where p.url is not null ")
                .list();
    }
}
