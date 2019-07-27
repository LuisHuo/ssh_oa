package com.hhl.oa.service;

import com.hhl.oa.base.DaoSupport;
import com.hhl.oa.domian.ForumManage;

import java.util.List;

public interface ForumManageService extends DaoSupport<ForumManage> {

    void save(ForumManage forumManage);
    void moveUp(Long id);
    void moveDown(Long id);
    List<ForumManage> findAll();
}
