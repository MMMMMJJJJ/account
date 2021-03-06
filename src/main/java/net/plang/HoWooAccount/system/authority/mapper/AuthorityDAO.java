package net.plang.HoWooAccount.system.authority.mapper;

import java.util.ArrayList;

import net.plang.HoWooAccount.system.authority.to.AuthorityEmpBean;
import net.plang.HoWooAccount.system.authority.to.AuthorityMenuBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorityDAO {

    public ArrayList<AuthorityEmpBean> selectAuthorityEmp(String deptCode);
    public void updateAuthority(AuthorityEmpBean authorityEmpBean, String dept);
    public ArrayList<AuthorityMenuBean> selectAuthorityMenu(String empCode);
}
