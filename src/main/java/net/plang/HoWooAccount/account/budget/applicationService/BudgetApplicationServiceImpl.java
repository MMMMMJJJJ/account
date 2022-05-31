package net.plang.HoWooAccount.account.budget.applicationService;

import java.util.ArrayList;
import java.util.HashMap;

import net.plang.HoWooAccount.account.budget.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.plang.HoWooAccount.account.budget.mapper.BudgetDAO;
import net.plang.HoWooAccount.account.budget.to.BudgetBean;

@Component
public class BudgetApplicationServiceImpl implements BudgetApplicationService{

	@Autowired
	private BudgetDAO budgetDAO;
	/*@Autowired
	private BudgetRepository budgetRepository;*/
		
	@Override
	public HashMap<String, Object> findBudget(BudgetBean bean) {

		bean = budgetDAO.selectBudget(bean);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("budgeBean", bean);
		map.put("errorCode", 0);
		map.put("errorMsg", "편성 예산 조회 완료");
		
		return map;
	}

	@Override
	public void orgBudget(BudgetBean bean) {

		budgetDAO.orgBudget(bean);
	}

	@Override
	public HashMap<String, Object> callBudgetStatus(BudgetBean bean) {

		HashMap<String,Object> params = new HashMap<String,Object>();
		
		params.put("accountPeriodNo", bean.getAccountPeriodNo());
		params.put("workplaceCode", bean.getWorkplaceCode());
		params.put("deptCode", bean.getDeptCode());
		
		budgetDAO.callBudgetStatus(params);

		return params;
	}

	@Override
	public HashMap<String, Object> findBudgetAppl(BudgetBean bean) {
		
		bean = budgetDAO.selectBudgetAppl(bean);
		
		HashMap<String,Object> map = new HashMap<>();
		map.put("budgetBean", bean);
		map.put("errorCode", 0);
		map.put("errorMsg", "예산 신청 조회 완료");
		
	return map;
	}

	@Override
	public ArrayList<BudgetBean> getAllBudget(){
		//(ArrayList<BudgetBean>)budgetRepository.findAll(); 이걸로 안쓴 이유.. 숫자를 인식 못함..
		//m9Budget이면 M9_BUDGET이 되야 하는데 M9BUDGET이 됨..
		return budgetDAO.selectAllBudget();
	};
}
