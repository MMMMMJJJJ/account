package net.plang.HoWooAccount.account.budget.to;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.plang.HoWooAccount.system.base.to.BaseBean;
import net.plang.HoWooAccount.system.common.annotation.Dataset;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(BudgetPkBean.class)
@Table(name="BUDGET")
@Dataset(name="gds_budget")
@Data
@Getter
public class BudgetBean {
	@Id
	private String deptCode;
	@Id
	private String workplaceCode;
	@Id
	private String accountInnerCode;
	@Id
	private String accountPeriodNo;
	@Id
	private String budgetingCode;
	private int m1Budget;
	private int m2Budget;
	private int m3Budget;
	private int m4Budget;
	private int m5Budget;
	private int m6Budget;
	private int m7Budget;
	private int m8Budget;
	private int m9Budget;
	private int m10Budget;
	private int m11Budget;
	private int m12Budget;
}
