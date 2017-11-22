package com.wzg.ssh.post.service;

import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.post.dao.PostDao;
import com.wzg.ssh.post.domain.Post;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class PostServiceImpl implements PostService {
    private PostDao postDao;

    // 查出所有的职位
    @Override
    public List<Post> getPost(Post post) {
        return postDao.getPost(post);
    }
    // 查出所有的部门
    @Override
    public List<Department> getDept() {
        return postDao.getDept();
    }

    // 编辑或者保存职位
    @Override
    public void saveOrEditPost(Post post) {
        postDao.saveOrEditPost(post);
    }




    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
