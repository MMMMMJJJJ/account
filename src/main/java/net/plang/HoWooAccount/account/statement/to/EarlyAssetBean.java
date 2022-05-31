package net.plang.HoWooAccount.account.statement.to;

import lombok.Getter;
import lombok.Setter;
import net.plang.HoWooAccount.system.base.to.BaseBean;

@Setter
@Getter
public class EarlyAssetBean extends BaseBean {
    private String gropuCode;
    private String accountInnerCode;
    private String accountName;
    private String price;
    private String statementsDivision;
    private String balanceDivision;
    private String leftDebtorPrice;
    private String rightCreditsPrice;
}
