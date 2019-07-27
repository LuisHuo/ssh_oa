package com.hhl.oa.Util;

import com.hhl.oa.domian.Privilege;
import com.hhl.oa.service.PrivilegeService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Collection;
import java.util.List;

public class InitListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext ac = WebApplicationContextUtils
                .getWebApplicationContext(servletContextEvent.getServletContext());
        PrivilegeService privilegeService = (PrivilegeService) ac.getBean("privilegeServiceImpl");
        List<Privilege> topPrivilege = privilegeService.findTopList();
        servletContextEvent.getServletContext().setAttribute("topPrivilege", topPrivilege);

        Collection<String > allPrivilegeUrls = privilegeService.getAllPrivilegeUrls();
        servletContextEvent.getServletContext().setAttribute("allPrivilegeUrls", allPrivilegeUrls);
        System.out.println("-------初始化成功-------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
