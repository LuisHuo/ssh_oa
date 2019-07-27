package com.hhl.oa.dao.Impl;

import com.hhl.oa.base.DaoSupport;
import com.hhl.oa.domian.Department;

import java.util.List;

@Deprecated
public interface DepartmentDaoSupport extends DaoSupport<Department> {
    List<Department> findDeptList(Long parentID);

    List<Department> findChildrenList(Long parentId);

    List<Department> findTopDeptList();
}
