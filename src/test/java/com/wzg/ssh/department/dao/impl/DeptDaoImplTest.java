package com.wzg.ssh.department.dao.impl;

import com.wzg.ssh.department.dao.DeptDao;
import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.post.domain.Post;
import com.wzg.ssh.staff.domain.Staff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/wzg/ssh/department/spring/dept-spring.xml")
public class DeptDaoImplTest {
    @Resource
    private DeptDao deptDao;


    // 测试根据部门ID查询所有职位
    @Test
    public void test(){
        Department department = new Department(2);

        List<Post> postList = deptDao.getPostByDeptId(department);

        for (Post post : postList) {
            System.out.println(post.getPostName());
        }

    }
    // 测试编辑或者保存部门
    @Test
    public void test1(){
        Department d = new Department("人事部");
        deptDao.saveOrUpdateDept(d);
    }
    // 测试查询所有部门
    @Test
    public void test2(){
        List<Department> depts = deptDao.getDept();
        depts.forEach(System.out::println);
    }






}