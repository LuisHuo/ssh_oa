package com.hhl.oa.view;

import com.hhl.oa.Util.DepartmentUtil;
import com.hhl.oa.base.BaseAction;
import com.hhl.oa.domian.Department;
import com.hhl.oa.domian.Role;
import com.hhl.oa.domian.User;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;

import javax.sql.rowset.spi.SyncResolver;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
    private Long deptId;
    private Long[] roleIds;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }

    public String list() throws Exception{
        List<User> userList = userService.findAll();
        ActionContext.getContext().put("userList", userList);
        return "list";
    }

    public String delete() throws Exception{
        userService.delete(model.getId());
        return "toList";
    }

    public String addUI() throws Exception{
        List<Department> deptTopList = departmentService.findTopDeptList();
        List<Department> deptList = DepartmentUtil.getDeptName(deptTopList);
        ActionContext.getContext().put("deptList", deptList);

        List<Role> roleList = roleService.findAll();
        ActionContext.getContext().put("roleList", roleList);

        return "saveUI";
    }

    public String add() throws Exception{
        Department department = departmentService.getById(deptId);
        model.setDepartment(department);

        List<Role> roles = roleService.getByIds(roleIds);
        model.setRoles(new HashSet<Role>(roles));

        String md5Digest = DigestUtils.md5DigestAsHex("1234".getBytes());
        model.setPassword(md5Digest);
        userService.save(model);
        return "toList";
    }

    public String editUI() throws Exception{
        List<Department> deptTopList = departmentService.findTopDeptList();
        List<Department> deptList = DepartmentUtil.getDeptName(deptTopList);
        ActionContext.getContext().put("deptList", deptList);

        List<Role> roleList = roleService.findAll();
        ActionContext.getContext().put("roleList", roleList);
        User user = userService.getById(model.getId());
        ActionContext.getContext().getValueStack().push(user);

        if (null != user.getDepartment()){
            deptId = user.getDepartment().getId();
        }
        Set<Role> roles = user.getRoles();
        if (null != user.getRoles()){
            roleIds = new Long[roles.size()];
            int index = 0;
            for (Role role : roles){
                roleIds[index++] = role.getId();
            }

        }
        return "saveUI";
    }

    public String edit() throws Exception{
        User user = userService.getById(model.getId());
        System.out.println(user);
        user.setDescription(model.getDescription());
        user.setEmail(model.getEmail());
        user.setPhoneNumber(model.getPhoneNumber());
        user.setLoginName(model.getLoginName());
        user.setGender(model.getGender());
        user.setName(model.getName());

        Department department = departmentService.getById(deptId);
        user.setDepartment(department);

        List<Role> roles = roleService.getByIds(roleIds);
        user.setRoles(new HashSet<Role>(roles));
        userService.update(user);
        return "toList";
    }

    public String initPassword() throws Exception{
        User user = userService.getById(model.getId());
        String md5Digest = DigestUtils.md5DigestAsHex("1234".getBytes());
        user.setPassword(md5Digest);
        userService.update(user);
        return "toList";
    }

    public String loginUI() throws Exception{

        return "loginUI";
    }

    public String login() throws Exception{
        String logName = model.getLoginName();
        String password = model.getPassword();
        User user = userService.findByLogin(logName, password);
        if (null == user){
            addFieldError("login", "用户名或密码错误");
            return "loginUI";
        }else {
            ActionContext.getContext().getSession().put("user", user);
            return "toIndex";
        }
    }

    public String logout() throws Exception{
        ActionContext.getContext().getSession().remove("user");
        return "logout";
    }
}
