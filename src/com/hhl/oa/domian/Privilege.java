package com.hhl.oa.domian;

import java.util.HashSet;
import java.util.Set;

//权限模块实体类
public class Privilege {
    private Long id;
    private String name;
    private String url;
    private Privilege parent;
    private Set<Role> roles = new HashSet<>();
    private Set<Privilege> children = new HashSet<>();

    public Privilege(){

    }

    public Privilege(String name, String url, Privilege parent) {
        this.name = name;
        this.url = url;
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Privilege getParent() {
        return parent;
    }

    public void setParent(Privilege parent) {
        this.parent = parent;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Privilege> getChildren() {
        return children;
    }

    public void setChildren(Set<Privilege> children) {
        this.children = children;
    }
}
