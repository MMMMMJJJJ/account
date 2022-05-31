package net.plang.HoWooAccount.account.statement.to;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.plang.HoWooAccount.system.common.annotation.Dataset;

@EqualsAndHashCode(callSuper=false)
@Dataset(name="ds_totalTrialBalance")
@Data
public class TotalTrialBalanceBean {

    private int lev;
    private String accountName;
    private String accountInnerCode;
    private long debitsSumBalance;
    private long debitsSum;
    private long creditsSum;
    private long creditsSumBalance;
}
