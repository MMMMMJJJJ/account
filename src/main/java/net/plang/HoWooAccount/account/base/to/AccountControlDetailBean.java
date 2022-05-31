package net.plang.HoWooAccount.account.base.to;

import lombok.Getter;
import net.plang.HoWooAccount.system.common.annotation.Dataset;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT_CONTROL_DETAIL")
@Dataset(name="gds_control_detail")
@Getter

public class AccountControlDetailBean {
    @Id
    private String accountControlCode;
    private String accountControlName;
    private String accountControlType;
    private String description;
}
