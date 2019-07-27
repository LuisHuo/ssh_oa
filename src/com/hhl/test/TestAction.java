package com.hhl.test;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
@Scope("prototype")
public class TestAction extends ActionSupport {

    @Resource
    ServiceTest serviceTest;
    public String actionTest(){
        serviceTest.savaTwoUser();
        System.out.println("成功");
        return SUCCESS;
    }
}
