package net.plang.HoWooAccount.account.base.serviceFacade;

import java.util.ArrayList;

import lombok.Setter;

import net.plang.HoWooAccount.account.base.Entity.AccountControlDetailEntity;
import net.plang.HoWooAccount.account.base.repository.AccountRepository;
import net.plang.HoWooAccount.account.base.to.*;
import net.plang.HoWooAccount.account.base.applicationService.AccountApplicationService;
import net.plang.HoWooAccount.system.common.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceFacadeImpl implements AccountServiceFacade {

    @Autowired
    private AccountApplicationService accountApplicationService;


    @Override
    public AccountBean getAccount(String accountCode) {
        return accountApplicationService.getAccount(accountCode);
    }

    @Override
    public ArrayList<AccountBean> findParentAccountList() {
        return accountApplicationService.findParentAccountList();
    }

    @Override
    public ArrayList<AccountBean> findDetailAccountList(String code) {
        return accountApplicationService.findDetailAccountList(code);
    }

    @Override
    public void updateAccount(AccountBean accountBean) {
           accountApplicationService.updateAccount(accountBean);
    }

    @Override
    public ArrayList<AccountBean> getAccountList(String accountName) {

        return accountApplicationService.getAccountList(accountName);
    }

    @Override
    public ArrayList<AccountControlDetailBean> getAccountControlList(String accountCode) {
        return accountApplicationService.getAccountControlList(accountCode);
    }

	@Override
	public ArrayList<AccountControlDetailEntity> findDetailBudgetList(String code) {
        return accountApplicationService.findDetailBudgetList(code);
	}

	@Override
	public ArrayList<AccountBean> findParentBudgetList() {
        return accountApplicationService.findParentBudgetList();
	}

	@Override
	public ArrayList<PeriodBean> findAccountPeriodList() {
        return accountApplicationService.findAccountPeriodList();
	}

	@Override
    public ArrayList<AccountControlDetailBean> getAccountControlDetail(){
        ArrayList<AccountControlDetailBean> acControl = accountApplicationService.getAccountControlDetail();
        return acControl;
    }

    @Override
    public ArrayList<AccountCodeBean> getAccountList(){
        return accountApplicationService.getAccountList();
    };
}
