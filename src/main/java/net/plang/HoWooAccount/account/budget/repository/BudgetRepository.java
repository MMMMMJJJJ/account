package net.plang.HoWooAccount.account.budget.repository;

import net.plang.HoWooAccount.account.budget.to.BudgetBean;
import org.springframework.data.repository.CrudRepository;

public interface BudgetRepository extends CrudRepository<BudgetBean,String> {
}
