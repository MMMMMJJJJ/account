package net.plang.HoWooAccount.account.base.Entity;

import lombok.Data;
import net.plang.HoWooAccount.system.common.annotation.Dataset;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Dataset(name="gds_account")
@Data
public class AccountControlDetailEntity {
    @Id
    private String accountInnerCode;
    private String accountName;
    private String parentAccountInnercode;
    private int editable;
    private String accountUseCheck;

}
