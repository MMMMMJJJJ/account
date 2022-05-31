package net.plang.HoWooAccount.account.budget.to;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class BudgetPkBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String deptCode;
    private String workplaceCode;
    private String accountInnerCode;
    private String accountPeriodNo;
    private String budgetingCode;

    public boolean equals(Object other) {
        return true;
    }

    public int hashCode() {
        return 0;
    }
}
