package net.plang.HoWooAccount.account.slip.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.plang.HoWooAccount.system.base.to.BaseBean;
import net.plang.HoWooAccount.system.common.annotation.Dataset;

@EqualsAndHashCode(callSuper=false)
@Dataset(name="gds_journalDetail")
@Data
public class JournalDetailBean extends BaseBean {

    private String journalDetailNo;
    private String accountControlName;
    private String accountControlType;
    private String journalDescription;
    private String accountControlDescription;
    private String journalNo;
    private String accountControlCode;
	
}
