package com.wzg.ssh.staff.domain;

import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.post.domain.Post;
import com.wzg.ssh.utils.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * Created by dllo on 17/11/9.
 */
public class DepartmentTest extends HibernateDaoSupport{
    // 插入数据的测试
    @Test
    public void saveStaff(){

        Session session = HibernateUtil.openSession();


        Department d1 = new Department("教学部");
        Department d2 = new Department("咨询部");

        Post p1 = new Post("总监");
        Post p3 = new Post("主管");
        Post p2 = new Post("讲师");
        Post p4 = new Post("资询总监");
        Post p5 = new Post("咨询讲师");



        Staff s1 = new Staff("wzg","123","你光哥","男","2012-6-08");
        s1.setDept(d1);
        s1.setPost(p1);
        p1.setDept(d1);



        Staff s2 = new Staff("绝世武神","456","武大","男","2016-8-9");
        s2.setDept(d1);
        s2.setPost(p2);
        p2.setDept(d1);



        Staff s5 = new Staff("MRLi","111","李忠仁","男","2014-8-8");
        s5.setDept(d1);
        s5.setPost(p3);
        p3.setDept(d1);



        Staff s3 = new Staff("mali","789","玛丽","女","2016-8-9");
        s3.setDept(d2);
        s3.setPost(p4);
        p4.setDept(d2);


        Staff s4 = new Staff("hexin","1234","小欣","女","2011-8-9");
        s4.setDept(d2);
        s4.setPost(p5);
        p5.setDept(d2);


        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(s4);
        session.save(s5);

        HibernateUtil.commit();


    }
}