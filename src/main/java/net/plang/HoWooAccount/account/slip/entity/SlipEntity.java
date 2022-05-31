package net.plang.HoWooAccount.account.slip.entity;

import lombok.Data;
import net.plang.HoWooAccount.system.common.annotation.Dataset;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="SLIP")
@Dataset(name="gds_slip")
@Data
public class SlipEntity {
    @Id
    private String slipNo;
    private String accountPeriodNo;
    private String deptCode;
    private String slipType;
    private String expenseReport;
    private String authorizationStatus;
    private String reportingEmpCode;
    private String reportingDate;
    private String approvalEmpCode;
    private String approvalDate;
    private String slipDescription;
    private String slipStatus;

    @Transient
    private String status;
}
