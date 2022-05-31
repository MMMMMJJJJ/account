package net.plang.HoWooAccount.account.base.applicationService;

import java.util.ArrayList;

import lombok.Setter;

import net.plang.HoWooAccount.account.base.Entity.AccountControlDetailEntity;
import net.plang.HoWooAccount.account.base.mapper.AccountDAO;
import net.plang.HoWooAccount.account.base.repository.AccountControlDetailRepository;
import net.plang.HoWooAccount.account.base.repository.AccountRepository;
import net.plang.HoWooAccount.account.base.to.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountApplicationServiceImpl implements AccountApplicationService {

	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private AccountControlDetailRepository accountControlDetailRepository;
	@Autowired
	private AccountRepository accountRepository;

	public AccountBean getAccount(String accountCode) {
		return accountDAO.selectAccount(accountCode);
	}

	@Override
	public ArrayList<AccountBean> findParentAccountList() {
		return accountDAO.selectParentAccountList();
	}

	public ArrayList<AccountBean> findDetailAccountList(String code) {
		return accountDAO.selectDetailAccountList(code);
	}

	@Override
	public void updateAccount(AccountBean accountBean) {

	}

	@Override
	public ArrayList<AccountBean> getAccountList(String accountName) {

		String checkInfo = accountName.substring(0,1);
		ArrayList<AccountBean> accountList =  null;
		if(checkInfo.equals("0") || checkInfo.equals("1")){
			accountList = accountRepository.findByAccountCodeContainingAndAccountCodeNotContaining(accountName,"-");
		}else{
			accountList = accountRepository.findByAccountNameContainingAndAccountCodeNotContaining(accountName,"-");
		}

		return accountList;
	}

	@Override
	public ArrayList<AccountControlDetailBean> getAccountControlList(String accountCode) {
		return accountDAO.selectAccountControlList(accountCode);
	}

	@Override
	public ArrayList<AccountControlDetailEntity> findDetailBudgetList(String code) {
		System.out.println("들어갈 데이터 " +code);
		return accountDAO.selectDetailBudgetList(code);
	}

	@Override
	public ArrayList<AccountBean> findParentBudgetList() {
		return accountDAO.selectParentBudgetList();
	}

	@Override
	public ArrayList<PeriodBean> findAccountPeriodList() {
		return accountDAO.selectAccountPeriodList();
	}

	@Override
	public ArrayList<AccountControlDetailBean> getAccountControlDetail(){

		ArrayList<AccountControlDetailBean> acControl = (ArrayList<AccountControlDetailBean>)accountControlDetailRepository.findAll();
		return acControl;
	}

	@Override
	public ArrayList<AccountCodeBean> getAccountList(){
		return accountDAO.getAccountList();
	};
}
