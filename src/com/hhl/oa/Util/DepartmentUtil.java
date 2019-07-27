package com.hhl.oa.Util;

import com.hhl.oa.domian.Department;
import com.hhl.oa.service.DepartmentService;
import com.hhl.oa.service.Impl.DepartmentServiceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DepartmentUtil {
    public static List<Department>getDeptName(List<Department> deptTopList){
        List<Department> deptNameList = new ArrayList<>();
        getName(deptTopList, "", deptNameList);
        return deptNameList;
    }

    private static void getName(Collection<Department> departments, String prefix, List<Department> list){

        for (Department dept : departments){
            Department deptCopy = new Department();
            deptCopy.setId(dept.getId());
            deptCopy.setName(prefix + "┠" + dept.getName());
            list.add(deptCopy);
            if (null == dept.getChildren()){
                continue;
            }
            getName(dept.getChildren(), "　" + prefix, list);
        }
    }
}
