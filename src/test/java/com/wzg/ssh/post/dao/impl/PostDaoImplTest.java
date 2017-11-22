package com.wzg.ssh.post.dao.impl;

import com.wzg.ssh.post.dao.PostDao;
import com.wzg.ssh.post.domain.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/wzg/ssh/post/spring/post-spring.xml")
public class PostDaoImplTest {
    @Resource
    private PostDao postDao;

    @Test
    public void getPost() throws Exception {
        Post p = new Post();
        List<Post> posts = postDao.getPost(p);
        posts.forEach(System.out::println);

    }

    @Test
    public void saveOrEditPost() throws Exception {
        Post p = new Post("技术攻关");
        postDao.saveOrEditPost(p);
    }

}