package net.plang.HoWooAccount.account.base.to;

import lombok.Data;
import net.plang.HoWooAccount.system.common.annotation.Dataset;

@Dataset(name="gds_accountCode")
@Data
public class AccountCodeBean {

    private String accountLevel;
    private String leaf;
    private String accountInnerCode;
    private String parentAccountInnerCode;
    private String accountCode;
    private String accountCharacter;
    private String accountName;
    private String accountDispalyNameWithCode;
    private String accountDisplayName;
    private String accountDivision;
    private String accountUseCheck;
    private String accountDescription;
    private String groupCode;

}
