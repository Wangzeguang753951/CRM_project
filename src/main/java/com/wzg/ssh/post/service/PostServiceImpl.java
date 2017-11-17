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


    @Override
    public List<Post> getPost(Post post) {
        return postDao.getPost(post);
    }

    @Override
    public List<Department> getDept() {
        return postDao.getDept();
    }

    @Override
    public void savePost(Post post) {
        postDao.savePost(post);
    }




    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
