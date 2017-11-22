package com.wzg.ssh.staff.service.impl;

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
 * Created by dllo on 17/11/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/wzg/ssh/staff/spring/staff-spring.xml")
public class StaffServiceImplTest {
    @Resource
    private StaffServiceImpl staffService;

    @Test
    public void getAllResult() throws Exception {

        Department d = new Department();

        Post p = new Post();

        Staff s = new Staff();
        // 高级查询测试
        //1
        List<Staff> result = staffService.getAllResult(-1, -1, "");
        result.forEach(System.out::println);
        //2
        List<Staff> result1 = staffService.getAllResult(1, -1, "");
        result1.forEach(System.out::println);
        //3
        List<Staff> result2 = staffService.getAllResult(1, 1, "");
        result2.forEach(System.out::println);
        //4
        List<Staff> result3 = staffService.getAllResult(1, 1, "光");
        result3.forEach(System.out::println);
        //5
        List<Staff> result4 = staffService.getAllResult(-1, -1, "关");
        result4.forEach(System.out::println);
        //6
        List<Staff> result5 = staffService.getAllResult(1, -1, "张");
        result5.forEach(System.out::println);


    }

}