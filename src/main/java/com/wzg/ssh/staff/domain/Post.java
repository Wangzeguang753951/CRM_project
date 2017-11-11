package com.wzg.ssh.staff.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/11/9.
 */
public class Post {
    private int id;
    private String postName;

    // 职位对应得部门多对一
    private Department dept;

    // 职位对应多个员工
    private Set<Staff>staffs = new HashSet<>();



    public Post() {
    }

    public Post(String postName) {
        this.postName = postName;
    }

    public Post(int id, String postName) {
        this.id = id;
        this.postName = postName;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postName='" + postName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }


    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }
}
