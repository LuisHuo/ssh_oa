package com.hhl.oa.service;

import com.hhl.oa.base.DaoSupport;
import com.hhl.oa.domian.Department;

import java.util.List;

public interface DepartmentService extends DaoSupport<Department> {
//    List<Department> findAll();
//
//    Department findById(Long id);
//
//    void delete(Long id);
//
//    void save(Department modelDept);
//
//    void update(Department dept);
//
//    List<Department> findDeptList(Long parentId);
//
    List<Department> findTopDeptList();

    List<Department> findChildrenList(Long parentId);
}
