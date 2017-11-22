package com.wzg.ssh.post.domain;

import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.staff.domain.Staff;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/11/9.
 */
public class Post {

    private int postId;
    private String postName;

    // 职位对应得部门多对一
    private Department dept;

    // 职位对应多个员工
    private Set<Staff>staffs = new HashSet<>();



    public Post() {
    }

    public Post(int postId) {
        this.postId = postId;
    }

    public Post(String postName) {
        this.postName = postName;
    }

    public Post(int postId, String postName) {
        this.postId = postId;
        this.postName = postName;
    }

    public Post(int postId, Department dept) {
        this.postId = postId;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postName='" + postName + '\'' +
                '}';
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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
