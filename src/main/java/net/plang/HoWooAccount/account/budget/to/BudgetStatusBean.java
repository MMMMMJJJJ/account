package net.plang.HoWooAccount.account.budget.to;

import lombok.Getter;
import lombok.Setter;
import net.plang.HoWooAccount.system.base.to.BaseBean;

@Setter
@Getter
public class BudgetStatusBean extends BaseBean{

private String accountInnerCode;
private String accountName;
private int annualBudgetRecord;//연간 예산 실적
private int annualBudget;
private int remainingBudget;
private double budgetExecRatio;//집행률
private int monthBudgetRecord;
private int monthBudget;
private int remainingMonthBudget;
private double monthBudgetExecRatio;//집행률

}
