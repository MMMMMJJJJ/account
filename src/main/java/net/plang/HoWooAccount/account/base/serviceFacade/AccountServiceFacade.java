package net.plang.HoWooAccount.account.base.serviceFacade;

import java.util.ArrayList;

import net.plang.HoWooAccount.account.base.Entity.AccountControlDetailEntity;
import net.plang.HoWooAccount.account.base.to.*;

public interface AccountServiceFacade {

    public AccountBean getAccount(String code);

    public ArrayList<AccountBean> findParentAccountList();

    public ArrayList<AccountBean> findDetailAccountList(String code);

    public void updateAccount(AccountBean accountBean);

    ArrayList<AccountBean> getAccountList(String accountName);

    ArrayList<AccountControlDetailBean> getAccountControlList(String accountCode);

    public ArrayList<AccountControlDetailEntity> findDetailBudgetList(String code);
    
    public ArrayList<AccountBean> findParentBudgetList();
    
    public ArrayList<PeriodBean> findAccountPeriodList();

    public ArrayList<AccountControlDetailBean> getAccountControlDetail();

    public ArrayList<AccountCodeBean> getAccountList();
}
