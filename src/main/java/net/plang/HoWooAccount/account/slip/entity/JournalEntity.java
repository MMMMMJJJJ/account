package net.plang.HoWooAccount.account.slip.entity;

import lombok.Data;
import net.plang.HoWooAccount.system.common.annotation.Dataset;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="JOURNAL")
@Dataset(name="gds_journal")
@Data
public class JournalEntity {
    @Id
    private String journalNo;
    private String slipNo;
    private String balanceDivision;
    private String accountInnerCode;
    //private String accountName;
    private String customerCode;
    private String leftDebtorPrice;
    private String rightCreditsPrice;

    @Transient
    private String status;
}
