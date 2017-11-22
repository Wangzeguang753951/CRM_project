package com.wzg.ssh.post.dao.impl;

import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.post.dao.PostDao;
import com.wzg.ssh.post.domain.Post;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class PostDaoImpl extends HibernateDaoSupport implements PostDao {


    //所有的职位
    @Override
    public List<Post> getPost(Post post) {
        return getHibernateTemplate().findByExample(post);
    }


    // 查出所有的部门
    @Override
    public List<Department> getDept() {
        String sql = "from Department crm_dept";
        return (List<Department>) getHibernateTemplate().find(sql);
    }


    // 根据部门ID保存职位
    @Override
    public void saveOrEditPost(Post post) {
        getHibernateTemplate().saveOrUpdate(post);
    }


}
