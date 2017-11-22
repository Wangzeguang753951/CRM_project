package com.wzg.ssh.post.service;

import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.post.domain.Post;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface PostService {



    /**
     * 查处所有职位
     * @return 职位集合
     */
    List<Post> getPost(Post post);



    /**
     * 在Post页面查出所有的部门
     * @return 职位集合
     */
    List<Department> getDept();



    /**
     * 根据部门ID保存职位
     * @param post
     * @return
     */
    void saveOrEditPost(Post post);




}
