package net.plang.HoWooAccount.system.authority.serviceFacade;

import java.util.ArrayList;

import net.plang.HoWooAccount.system.authority.to.AuthorityBean;
import net.plang.HoWooAccount.system.authority.to.AuthorityEmpBean;
import net.plang.HoWooAccount.system.authority.to.AuthorityMenuBean;

public interface AuthorityServiceFacade {

    public ArrayList<AuthorityEmpBean> findAuthorityEmp(String deptCode);
    public void updateAuthority(ArrayList<AuthorityEmpBean> authorityEmpBean, String dept);
    public ArrayList<AuthorityMenuBean> findEmpAuthorityList(String empCode);
    public ArrayList<AuthorityEmpBean> findAuthorityEmpList();
    public ArrayList<AuthorityBean> findAuthorityList();
    public ArrayList<AuthorityMenuBean> findAuthorityMenuList();
}
