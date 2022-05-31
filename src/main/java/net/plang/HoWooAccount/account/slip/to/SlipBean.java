package net.plang.HoWooAccount.account.slip.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.plang.HoWooAccount.system.base.to.BaseBean;
import net.plang.HoWooAccount.system.common.annotation.Dataset;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper=false)
@Dataset(name="gds_slip")
@Data
public class SlipBean extends BaseBean {
    //아 윗기수가 분리 해 둔 이유가 bean이 Table이랑 좀 차이가 있구나..정석대로라면 분리 하는게 맞으니까 분리 해야겠다.
    private String id;
    private String slipNo;
    private String accountPeriodNo;
    private String deptCode;
    private String deptName;
    private String slipType;
    private String expenseReport;
    private String authorizationStatus;
    private String reportingEmpCode;
    private String reportingEmpName;
    private String reportingDate;
    private String approvalEmpCode;
    private String approvalDate;
    private String slipStatus;
    private String balanceDivision;
    private String positionCode;

}
