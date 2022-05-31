package net.plang.HoWooAccount.account.statement.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.plang.HoWooAccount.system.base.to.BaseBean;
import net.plang.HoWooAccount.system.common.annotation.Dataset;


@EqualsAndHashCode(callSuper=false)
@Dataset(name="ds_financialStatements")
@Data
public class FinancialPositionBean extends BaseBean {
    private int lev;
    private String category;
    private String accountName;
    private String accountCode;
    private long balanceDetail;
    private long balanceSummary;
    private long preBalanceDetail;
    private long preBalanceSummary;
    private int isThisYear;

}
