package com.wzg.ssh.staff.service.impl;

import com.wzg.ssh.staff.dao.StaffDao;
import com.wzg.ssh.staff.dao.impl.StaffDaoImpl;
import com.wzg.ssh.staff.domain.Staff;
import org.junit.Test;

/**
 * Created by dllo on 17/11/10.
 */
public class StaffServiceImplTest {
    private StaffDao dao = new StaffDaoImpl();

    private Staff staff = new Staff();
    @Test
    public void login(){
        dao.login(staff);
    }

}