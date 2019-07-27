package com.hhl.oa.view;

import com.hhl.oa.base.BaseAction;
import com.hhl.oa.domian.Privilege;
import com.hhl.oa.domian.Role;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {

    private Long[] privilegeIds;

    public Long[] getPrivilegeIds() {
        return privilegeIds;
    }

    public void setPrivilegeIds(Long[] privilegeIds) {
        this.privilegeIds = privilegeIds;
    }

    public String list() throws Exception{
        List<Role> roleList = roleService.findAll();
        ActionContext.getContext().put("roleList", roleList);
        return "list";
    }

    public String delete() throws Exception{
        roleService.delete(model.getId());
        return "toList";
    }

    public String addUI() throws Exception{
        return "addUI";
    }

    public String add() throws Exception{
        roleService.save(model);
        return "toList";
    }

    public String editUI() throws Exception{
        //ActionContext.getContext().getValueStack().push(model);
        Role role = roleService.getById(model.getId());
        //ActionContext.getContext().getValueStack().push(role);
        ActionContext.getContext().getValueStack().push(role);
        return "editUI";
    }

    public String edit() throws Exception{
        Role role = roleService.getById(model.getId());
        role.setName(model.getName());
        role.setDescription(model.getDescription());
        roleService.update(role);
        //roleService.update(model);
        return "toList";
    }

    public String setPrivilegeUI() throws Exception{
        //ActionContext.getContext().getValueStack().push(model);
        Role role = roleService.getById(model.getId());
        //ActionContext.getContext().getValueStack().push(role);
        Set<Privilege> privileges = role.getPrivileges();
        if (null != privileges && 0 != privileges.size()) {
            int index = 0;
            privilegeIds = new Long[privileges.size()];
            for (Privilege pri : privileges) {
                privilegeIds[index++] = pri.getId();
            }
        }
        ActionContext.getContext().getValueStack().push(role);

        List<Privilege> privilegeList = privilegeService.findAll();
        ActionContext.getContext().put("privilegeList", privilegeList);
        return "setPrivilegeUI";
    }

    public String setPrivilege() throws Exception{
        Role role = roleService.getById(model.getId());

        List<Privilege> privilegeList = privilegeService.getByIds(privilegeIds);
        role.setPrivileges(new HashSet<Privilege>(privilegeList));

        roleService.update(role);
        //roleService.update(model);
        return "toList";
    }
}
