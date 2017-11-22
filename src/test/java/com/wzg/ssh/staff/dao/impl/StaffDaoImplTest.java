package com.wzg.ssh.staff.dao.impl;

import com.wzg.ssh.staff.dao.StaffDao;
import com.wzg.ssh.staff.domain.Staff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.swing.*;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/wzg/ssh/staff/spring/staff-spring.xml")
public class StaffDaoImplTest {
    @Resource
    private StaffDao staffDao;

    @Test
    public void getStaff() throws Exception {
        Staff staff = new Staff();
        staffDao.getStaff(staff);
    }



}