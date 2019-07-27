package com.hhl.oa.domian;

import com.opensymphony.xwork2.ActionContext;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class User {
    private long id;
    private String name;
    private String loginName;
    private String password;
    private String gender;
    private String phoneNumber;
    private String email;
    private String description;
    private Department department;
    private Set<Role> roles = new HashSet<Role>();

    public Boolean hasPrivilegeByName(String name){
        if (isAdmin()){
            return true;
        }
        for (Role role : roles){
            for (Privilege pri : role.getPrivileges()){
                if (pri.getName().equals(name)){
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean hasPrivilegeByPriUrl(String priUrl){
        if (isAdmin()){
            return true;
        }

        int pos = priUrl.indexOf("?");
        if (-1 < pos){
            priUrl = priUrl.substring(0, pos);
        }
        if (priUrl.endsWith("UI")){
            priUrl = priUrl.substring(0, priUrl.length() - 2);
        }

        Collection<String> allUrls = (Collection<String>) ActionContext.getContext().getApplication().get("allPrivilegeUrls");
        if (!allUrls.contains(priUrl)){
            return true;
        }
        for (Role role : roles){
            for (Privilege pri : role.getPrivileges()){
                if (priUrl.equals(pri.getUrl())){
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean isAdmin(){
        if ("admin".equals(loginName)){
            return true;
        }
        return false;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
