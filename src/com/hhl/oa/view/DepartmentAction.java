package com.hhl.oa.view;

import com.hhl.oa.Util.DepartmentUtil;
import com.hhl.oa.base.BaseAction;
import com.hhl.oa.domian.Department;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {

    private Long parentId;

    public String list(){
//        List<Department> deptList = departmentService.findAll();
        List<Department>  deptList = null;
        if (null == parentId){
            deptList = departmentService.findTopDeptList();
        }else {
            deptList = departmentService.findChildrenList(parentId);
        }
//        List<Department> deptList = departmentService.findTopDeptList(parentId);
        Department parent = departmentService.getById(parentId);
        ActionContext.getContext().put("parent", parent);
        ActionContext.getContext().put("deptList", deptList);
        return "list";
    }

    public String delete(){
        departmentService.delete(model.getId());
        return "toList";
    }

    public String addUI(){
        List<Department> deptTopList = departmentService.findTopDeptList();
        List<Department> deptList = DepartmentUtil.getDeptName(deptTopList);
        ActionContext.getContext().put("deptList", deptList);
        return "saveUI";
    }

    public String editUI(){
        Department dept = departmentService.getById(model.getId());
        List<Department> deptList = departmentService.findAll();
        ActionContext.getContext().put("deptList", deptList);
        ActionContext.getContext().getValueStack().push(dept);
        if (null != dept.getParent() && dept.getParent().getId() != null){
            parentId = dept.getParent().getId();
        }
        return "saveUI";
    }

    public String add(){
        Department parent = departmentService.getById(parentId);
        model.setParent(parent);
        departmentService.save(model);
        return "toList";
    }

    public String edit(){
        Department dept = departmentService.getById(model.getId());
        Department parent = departmentService.getById(parentId);
        dept.setName(model.getName());
        dept.setDescription(model.getDescription());
        dept.setParent(parent);
        departmentService.update(dept);
        return "toList";
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
