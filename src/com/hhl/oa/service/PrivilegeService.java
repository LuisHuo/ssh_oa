package com.hhl.oa.service;

import com.hhl.oa.base.DaoSupport;
import com.hhl.oa.domian.Privilege;

import java.util.Collection;
import java.util.List;

public interface PrivilegeService extends DaoSupport<Privilege> {

    List<Privilege> findTopList();

    Collection<String> getAllPrivilegeUrls();
}
