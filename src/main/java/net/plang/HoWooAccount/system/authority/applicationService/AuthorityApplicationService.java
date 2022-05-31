package net.plang.HoWooAccount.system.authority.applicationService;

import java.util.ArrayList;

import net.plang.HoWooAccount.hr.affair.to.DepartmentBean;
import net.plang.HoWooAccount.system.authority.to.AuthorityBean;
import net.plang.HoWooAccount.system.authority.to.AuthorityEmpBean;
import net.plang.HoWooAccount.system.authority.to.AuthorityMenuBean;

public interface AuthorityApplicationService {
    public ArrayList<AuthorityEmpBean> findAuthorityEmp(String deptCode);
    public void updateAuthority(ArrayList<AuthorityEmpBean> authorityEmpBean, String dept);
    public ArrayList<AuthorityMenuBean> findEmpAuthorityList(String empCode);
    public ArrayList<AuthorityEmpBean> findAuthorityEmpList();
    public ArrayList<AuthorityBean> findAuthorityList();
    public ArrayList<AuthorityMenuBean> findAuthorityMenuList();
}
