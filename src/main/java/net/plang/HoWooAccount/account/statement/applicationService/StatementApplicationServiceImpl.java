package net.plang.HoWooAccount.account.statement.applicationService;

import java.util.ArrayList;
import java.util.HashMap;

import net.plang.HoWooAccount.account.statement.mapper.*;
import net.plang.HoWooAccount.account.statement.to.CashJournalBean;
import net.plang.HoWooAccount.account.statement.to.DetailTrialBalanceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatementApplicationServiceImpl implements StatementApplicationService {

    @Autowired
    private TotalTrialBalanceDAO totalTrialBalanceDAO;
    @Autowired
    private FinancialPositionDAO financialPositionDAO;
    @Autowired
    private IncomeStatementDAO IncomeStatementDAO;
    @Autowired
    private DetailTrialBalanceDAO detailTrialBalanceDAO;
    @Autowired
    private CashJournalDAO cashJournalDAO;


    @Override
    public HashMap<String,Object> getTotalTrialBalance(HashMap<String, Object> param) {
        totalTrialBalanceDAO.callTotalTrialBalance(param);
        return param;
    }

    @Override
    public HashMap<String, Object> getIncomeStatement(HashMap<String, Object> param) {
        IncomeStatementDAO.callIncomeStatement(param);
        return param;
    }

    @Override
    public HashMap<String, Object> getFinancialPosition(HashMap<String, Object> param) {
        financialPositionDAO.callFinancialPosition(param);
        return param;
    }

	@Override
	public ArrayList<DetailTrialBalanceBean> getDetailTrialBalance(HashMap<String, String> param) {
        return detailTrialBalanceDAO.selectDetailTrialBalance(param);
	}

	@Override
	public ArrayList<CashJournalBean> getCashJournal(HashMap<String, String> param) {
        return cashJournalDAO.selectCashJournalList(param);
	}

	@Override
	public HashMap<String, Object> getEarlyStatements(HashMap<String, Object> param) {
        return totalTrialBalanceDAO.callEarlyStatements(param);
    }

	@Override
	public HashMap<String, Object> changeAccountingSettlement(HashMap<String, Object> param) {
        return totalTrialBalanceDAO.updateAccountingSettlement(param);
    }

    public void insertEarlyStatements(String periodNo){
        HashMap<String, Object> map = new HashMap<>();
        map.put("accountPeriodNo", periodNo);
        map.put("callResult","Y");
        totalTrialBalanceDAO.callEarlyStatements(map);
    };
}
