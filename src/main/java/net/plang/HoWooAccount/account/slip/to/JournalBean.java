package net.plang.HoWooAccount.account.slip.to;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.plang.HoWooAccount.system.base.to.BaseBean;
import net.plang.HoWooAccount.system.common.annotation.Dataset;

@EqualsAndHashCode(callSuper=false)
@Dataset(name="gds_journal")
@Data
public class JournalBean extends BaseBean {
    private String id;
    private String slipNo;
    private String journalNo;
    private String balanceDivision;
    private String accountInnerCode;
    private String accountName;
    private String customerCode;
    private String customerName;
    private String leftDebtorPrice;
    private String rightCreditsPrice;
    private String price;
    private String deptCode;
    private String accountPeriodNo;
    private String reportingDate;
    private String expenseReport;
    private String accountCode;
    private List<JournalDetailBean> journalDetailList;

}
