package com.wzg.ssh.post.web.action;

import com.wzg.ssh.base.BaseAction;
import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.post.domain.Post;
import com.wzg.ssh.post.service.PostService;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class PostAction extends BaseAction<Post, PostService> {


    private List<Post> posts;

    private List<Department> departments;



    private int deptId;
    private String deptName;



    public String getPost() {
        posts = service.getPost(getModel());
        return SUCCESS;
    }

    public String getDept() {
        departments = service.getDept();
        System.out.println(getModel().getPostId() + "------");
        return SUCCESS;
    }


    public String savePost() {
//            getModel().setDept(new Department(deptId, deptName));
//            System.out.println(deptId);
        System.out.println(getModel());
        service.savePost(getModel());
            return SUCCESS;
    }






    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }



    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}
