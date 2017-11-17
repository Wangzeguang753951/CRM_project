package com.wzg.ssh.staff.dao.impl;

import com.opensymphony.xwork2.ActionContext;
import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.post.domain.Post;
import com.wzg.ssh.staff.dao.StaffDao;
import com.wzg.ssh.staff.domain.Staff;
import com.wzg.ssh.utils.MD5Util;
import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {

    // 查查出数据库中的员工信息集合
    @Override
    public Staff login(Staff staff) {
        String md5 = MD5Util.getMd5(staff.getLoginPwd());
        staff.setLoginPwd(md5);
        List<Staff> staffs = getHibernateTemplate().findByExample(staff);
        if (staffs != null && staffs.size() > 0) {
            return staffs.get(0);
        } else {

            return null;
        }

    }

    //查询所有员工
    @Override
    public List<Staff> getStaff(Staff staff) {

        List<Staff> staffs = getHibernateTemplate().loadAll(Staff.class);
        if (staffs != null && staffs.size() > 0) {
            return staffs;
        }
        return null;
    }


    // 保存或者编辑员工信息
    @Override
    public void saveOrUpdate(Staff staff) {
        getHibernateTemplate().saveOrUpdate(staff);

    }

    // 查询所有部门
    @Override
    public List<Department> getDept() {
        String sql = "from Department crm_dept";
        return (List<Department>) getHibernateTemplate().find(sql);
    }

    @Override
    public List<Staff> getAllResult(int deptId, int postId, String staffName) {

        if (deptId > 0 && postId == 0 && staffName.equals("")) {

            String sql1 = "from Staff crm_staff where dept.deptId=?";
            return (List<Staff>) getHibernateTemplate().find(sql1, deptId);

        } else if (deptId == 0 && postId == 0 && !staffName.equals("")) {
            String sql4 = "from Staff crm_staff where staffName like ?";
            return (List<Staff>) getHibernateTemplate().find(sql4, "%" + staffName + "%");


        } else if (deptId > 0 && postId > 0 && !staffName.equals("")) {

            String sql3 = "from Staff crm_staff where dept.deptId=? and post.postId=? and staffName like ?";
            return (List<Staff>) getHibernateTemplate().find(sql3, deptId, postId, "%" + staffName + "%");

        } else if (deptId > 0 && postId > 0 && staffName.equals("")) {
            String sql2 = "from Staff crm_staff where dept.deptId=? and post.postId = ?";
            return (List<Staff>) getHibernateTemplate().find(sql2, deptId, postId);

        } else if (deptId > 0 && postId == 0 && !staffName.equals("")) {

            String sql6 = "from Staff crm_staff where dept.deptId=? and staffName like ?";
            getHibernateTemplate().find(sql6, deptId, "%" + staffName + "%");
        } else {

            String sql5 = "from Staff crm_staff";
            return (List<Staff>) getHibernateTemplate().find(sql5);
        }
        return null;

    }


}
