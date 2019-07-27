package com.hhl.oa.dao.Impl;

import com.hhl.oa.base.DaoSupportImpl;
import com.hhl.oa.domian.Department;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

import java.util.List;
@Deprecated
@Repository
public class DepartmentDaoSupportImpl extends DaoSupportImpl<Department> implements DepartmentDaoSupport {

    @Override
    public List<Department> findDeptList(Long parentId) {
        Session session = getSession();
        List <Department> deptList = null;
        if (null == parentId){
            deptList = session.createQuery("FROM Department dept where dept.parent is null").list();
        }else {
            deptList = session.createQuery(
                    "FROM Department dept where dept.parent.id = ?0")
                    .setParameter(0, parentId)
                    .list();
        }
        return deptList;
    }

    @Override
    public List<Department> findTopDeptList() {
        Session session = getSession();
        List<Department> deptList = session.createQuery("FROM Department dept where dept.parent is null").list();
        return deptList;
    }

    @Override
    public List<Department> findChildrenList(Long parentId) {
        Session session = getSession();
        List<Department> deptList = session.createQuery(
                "FROM Department dept where dept.parent.id = ?0")
                .setParameter(0, parentId)
                .list();

        return deptList;
    }
}
