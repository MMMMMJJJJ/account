package net.plang.HoWooAccount.account.statement.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.plang.HoWooAccount.system.base.to.BaseBean;
import net.plang.HoWooAccount.system.common.annotation.Dataset;

@EqualsAndHashCode(callSuper=false)
@Dataset(name="ds_IncomeStatement")
@Data
public class IncomeStatementBean extends BaseBean {
    private String accountInnerCode;
    private String accountName;
    private String parentAccountCode;
    private String income;
    private String incomeSummary;
    private String earlyIncome;
    private String earlyIncomeSummary;
    private String isThisYear;

}
