package com.wzg.ssh.staff.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/11/9.
 */
public class Department {
    private int id;
    private String deptName;

    // 部门一对多 有多个职位 多个员工

    private Set<Post> posts = new HashSet<>();

    private Set<Staff> staffs = new HashSet<>();


    public Department() {
    }

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public Department(int id, String deptName) {
        this.id = id;
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }
}
