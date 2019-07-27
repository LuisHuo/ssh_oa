package com.hhl.oa.Util;

import com.hhl.oa.domian.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckPrivilegeInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {

        User user = (User) ActionContext.getContext().getSession().get("user");
        String namespace = actionInvocation.getProxy().getNamespace();
        String actionName = actionInvocation.getProxy().getActionName();
        String priUrl = namespace + actionName;
        if (null == user){
            if (priUrl.startsWith("/user_login")){
                return actionInvocation.invoke();
            }else {
                return "loginUI";
            }
        }else {
            if (user.hasPrivilegeByPriUrl(priUrl)){
                return actionInvocation.invoke();
            }else {
                return "noPrivilege";
            }

        }
    }
}
