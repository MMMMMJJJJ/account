package net.plang.HoWooAccount.system.authority.serviceFacade;

import net.plang.HoWooAccount.system.authority.applicationService.AuthorityApplicationService;
import net.plang.HoWooAccount.system.authority.to.AuthorityBean;
import net.plang.HoWooAccount.system.authority.to.AuthorityEmpBean;
import net.plang.HoWooAccount.system.authority.to.AuthorityMenuBean;
import net.plang.HoWooAccount.system.common.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthorityServiceFacadeImpl implements AuthorityServiceFacade {
    @Autowired
    private AuthorityApplicationService authorityApplicationService;

    @Override
    public ArrayList<AuthorityEmpBean> findAuthorityEmp(String deptCode) {

        ArrayList<AuthorityEmpBean> authorityEmp = null;
        authorityEmp = authorityApplicationService.findAuthorityEmp(deptCode);
        return authorityEmp;
    }

	@Override
	public void updateAuthority(ArrayList<AuthorityEmpBean> authorityEmpBean, String dept) {

        try {
            authorityApplicationService.updateAuthority(authorityEmpBean, dept);
        } catch (DataAccessException e) {
            throw e;
        }
	}

	@Override
    public ArrayList<AuthorityMenuBean> findEmpAuthorityList(String empCode){

        ArrayList<AuthorityMenuBean> authorityList=authorityApplicationService.findEmpAuthorityList(empCode);

        return authorityList;
    }

    @Override
    public ArrayList<AuthorityEmpBean> findAuthorityEmpList(){
        return authorityApplicationService.findAuthorityEmpList();
    }

    @Override
    public ArrayList<AuthorityBean> findAuthorityList(){
        return authorityApplicationService.findAuthorityList();
    }

    @Override
    public ArrayList<AuthorityMenuBean> findAuthorityMenuList(){
        return authorityApplicationService.findAuthorityMenuList();
    }
}
