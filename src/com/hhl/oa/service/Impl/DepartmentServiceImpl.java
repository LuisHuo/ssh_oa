package com.hhl.oa.service.Impl;

import com.hhl.oa.base.DaoSupportImpl;
import com.hhl.oa.domian.Department;
import com.hhl.oa.service.DepartmentService;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl extends DaoSupportImpl<Department> implements DepartmentService {
    @Resource
    private SessionFactory session;

    @Override
    public List<Department> findTopDeptList() {
        List<Department> deptList = session.getCurrentSession().createQuery("FROM Department dept where dept.parent is null").list();
        return deptList;
    }

    @Override
    public List<Department> findChildrenList(Long parentId) {
        List<Department> deptList = session.getCurrentSession().createQuery(
                "FROM Department dept where dept.parent.id = ?0")
                .setParameter(0, parentId)
                .list();

        return deptList;
    }
}
