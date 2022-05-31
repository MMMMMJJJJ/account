package net.plang.HoWooAccount.account.base.mapper;

import java.util.ArrayList;

import net.plang.HoWooAccount.account.base.Entity.AccountControlDetailEntity;
import net.plang.HoWooAccount.account.base.to.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountDAO {

    public AccountBean selectAccount(String accountCode);

    public ArrayList<AccountBean> selectDetailAccountList(String code);

    public ArrayList<AccountBean> selectParentAccountList();

    public ArrayList<AccountBean> selectAccountListByName(String accountName);

    public ArrayList<AccountControlDetailBean> selectAccountControlList(String accountCode);

    public ArrayList<AccountControlDetailEntity> selectDetailBudgetList(String code);

    public ArrayList<AccountBean> selectParentBudgetList();
    
    public ArrayList<PeriodBean> selectAccountPeriodList();

    public ArrayList<AccountCodeBean> getAccountList();
}
