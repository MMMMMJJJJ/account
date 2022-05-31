package net.plang.HoWooAccount.account.base.repository;

import net.plang.HoWooAccount.account.base.to.AccountBean;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface AccountRepository extends CrudRepository<AccountBean,String> {
    AccountBean findByParentAccountInnerCodeIsNotNullAndAccountInnerCode(String accountInnercode);
    //where account_inner_code is not null and account_inner_code = ?

    ArrayList<AccountBean> findByAccountNameContaining(String accountName);
    // where accountName like %accountName%

    ArrayList<AccountBean> findByAccountInnerCodeContainingAndAccountInnerCodeNotInAndAccountInnerCodeNotNullOrderByAccountInnerCode(String accountInnerCode,String[] arrayCode);
    // where ACCOUNT_INNER_CODE like %1?% and ACCOUNT_INNER_CODE not in 2? and ACCOUNT_INNER_CODE not null order by ACCOUNT_INNER_CODE ;

    ArrayList<AccountBean> findByAccountInnerCodeNotContainingAndParentAccountInnerCodeContainingOrderByAccountInnerCode(String accountInnerCode,String parentAccountInnerCode);
    // where ACCOUNT_INNER_CODE not like %1?% and PARENT_ACCOUNT_INNER_CODE like %2?% order by ACCOUNT_INNER_CODE ;

    ArrayList<AccountBean> findByAccountNameContainingAndAccountCodeNotContaining(String accountName, String accountCode);
    // select * from Account where ACCOUNT_NAME like %?1% and ACCOUNT_CODE not like %?2%

    ArrayList<AccountBean> findByAccountCodeContainingAndAccountCodeNotContaining(String sAccountCode,String accountCode);
}
