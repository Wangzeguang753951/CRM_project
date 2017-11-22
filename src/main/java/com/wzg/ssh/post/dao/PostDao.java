package com.wzg.ssh.post.dao;

import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.post.domain.Post;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface PostDao {

    /**
     * 查出所有职位
     * @return
     */
    List<Post> getPost(Post post);



    /**
     *  点击职位管理 查询所有部门
     * @return
     */
    List<Department> getDept();


    /**
     * 保存职位
     * @param post
     */
    void saveOrEditPost(Post post);



}
