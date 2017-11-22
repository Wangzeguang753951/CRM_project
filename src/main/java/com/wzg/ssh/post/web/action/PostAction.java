package com.wzg.ssh.post.web.action;

import com.wzg.ssh.base.BaseAction;
import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.post.domain.Post;
import com.wzg.ssh.post.service.PostService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class PostAction extends BaseAction<Post, PostService> {

    // 所有职位集合
    private List<Post> posts;
    // 所有部门的集合
    private List<Department> departments;


    //查询出所有的职位
    public String getPost() {
        posts = service.getPost(getModel());
        return SUCCESS;
    }


    //查出所有的部门
    public String getDept() {
        departments = service.getDept();
        return SUCCESS;
    }


    //编辑或者保存
    public String saveOrEditPost() {
        // 对保存和编辑部门进行验证
        if(getModel().getPostName().equals("")){
            addActionError("请填写部门名字");
            departments = service.getDept();
            return INPUT;
        }else if (getModel().getDept().getDeptId() < 0){
            addActionError("请选择职务");
            departments = service.getDept();
            return INPUT;
        }

            service.saveOrEditPost(getModel());
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


}
