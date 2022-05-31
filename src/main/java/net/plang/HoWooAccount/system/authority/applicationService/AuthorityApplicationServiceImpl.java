package net.plang.HoWooAccount.system.authority.applicationService;

import java.util.ArrayList;

import net.plang.HoWooAccount.system.authority.mapper.AuthorityDAO;
import net.plang.HoWooAccount.system.authority.repository.AuthorityEmpRepository;
import net.plang.HoWooAccount.system.authority.repository.AuthorityMenuRepository;
import net.plang.HoWooAccount.system.authority.repository.AuthorityRepository;
import net.plang.HoWooAccount.system.authority.to.AuthorityBean;
import net.plang.HoWooAccount.system.authority.to.AuthorityEmpBean;
import net.plang.HoWooAccount.system.authority.to.AuthorityMenuBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorityApplicationServiceImpl implements AuthorityApplicationService {
	@Autowired
    private AuthorityDAO authorityDAO;
	@Autowired
	private AuthorityEmpRepository authorityEmpRepository;
	@Autowired
	private AuthorityRepository authorityRepository;
	@Autowired
	private AuthorityMenuRepository authorityMenuRepository;

	@Override
	public ArrayList<AuthorityEmpBean> findAuthorityEmp(String deptCode) {
		ArrayList<AuthorityEmpBean> authorityEmp = authorityDAO.selectAuthorityEmp(deptCode);
		return authorityEmp;
	}

	@Override
	public void updateAuthority(ArrayList<AuthorityEmpBean> authorityEmpBean, String dept) {
		for(AuthorityEmpBean bean : authorityEmpBean) {
			authorityDAO.updateAuthority(bean, dept);
		}
	}

	@Override
	public ArrayList<AuthorityMenuBean> findEmpAuthorityList(String empCode){
		ArrayList<AuthorityMenuBean> authorityList = authorityDAO.selectAuthorityMenu(empCode);
		return authorityList;
	}

	@Override
	public ArrayList<AuthorityEmpBean> findAuthorityEmpList(){
		return (ArrayList<AuthorityEmpBean>)authorityEmpRepository.findAll();
	}

	@Override
	public ArrayList<AuthorityBean> findAuthorityList(){
		return (ArrayList<AuthorityBean>)authorityRepository.findAll();
	}

	@Override
	public ArrayList<AuthorityMenuBean> findAuthorityMenuList(){
		return (ArrayList<AuthorityMenuBean>)authorityMenuRepository.findAll();
	}
}
