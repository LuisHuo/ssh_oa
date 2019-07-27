package com.hhl.oa.view;

import com.hhl.oa.base.BaseAction;
import com.hhl.oa.domian.ForumManage;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("prototype")
public class ForumManageAction extends BaseAction<ForumManage> {

    public String list(){
        List<ForumManage> forumList = forumManageService.findAll();
        ActionContext.getContext().put("forumList", forumList);
        return "list";
    }

    public String delete(){
        forumManageService.delete(model.getId());
        return "toList";
    }

    public String addUI(){
        return "saveUI";
    }

    public String add(){
        forumManageService.save(model);
        return "toList";
    }

    public String editUI(){
        ForumManage forum = forumManageService.getById(model.getId());
        ActionContext.getContext().getValueStack().push(forum);
        return "saveUI";
    }

    public String edit(){
        ForumManage forum = forumManageService.getById(model.getId());
        forum.setDescription(model.getDescription());
        forum.setName(model.getName());
        forumManageService.update(forum);
        return "toList";
    }

    public String moveUp(){
        forumManageService.moveUp(model.getId());
        return "toList";
    }

    public String moveDown(){
        forumManageService.moveDown(model.getId());
        return "toList";
    }
}
