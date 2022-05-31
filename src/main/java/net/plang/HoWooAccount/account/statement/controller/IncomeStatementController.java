package net.plang.HoWooAccount.account.statement.controller;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.HoWooAccount.account.statement.serviceFacade.StatementServiceFacade;
import net.plang.HoWooAccount.account.statement.to.IncomeStatementBean;
import net.plang.HoWooAccount.system.common.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class IncomeStatementController {

    @Autowired
    private StatementServiceFacade statementServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping(value = "SpringBoot_Account/account/statement/incomeStatement")
    public HashMap<String, Object> incomeStatement(@RequestAttribute("reqData") PlatformData reqData,
                                                   @RequestAttribute("resData") PlatformData resData) throws Exception {
        String accountPeriodNo = reqData.getVariable("periodNo").getString();
        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("accountPeriodNo",accountPeriodNo);
        paramMap.put("callResult","SEARCH");

        HashMap<String, Object> resultMap =  statementServiceFacade.getIncomeStatement(paramMap);  //프로시저P_INCOME_STATEMENT
        ArrayList<IncomeStatementBean> incomeStatementList = (ArrayList<IncomeStatementBean>)resultMap.get("incomeStatement");

        /*for(IncomeStatementBean incomeStatementBean:incomeStatementList){   //기수가 새로 생기면서 0이 안들어 가 있어서 null을 강제로 넣어주는 로직인데..
            System.out.println(incomeStatementBean.getAccountName());
            System.out.println(incomeStatementBean.getIncomeSummary());
            System.out.println(incomeStatementBean.getEarlyIncomeSummary());

            if(incomeStatementBean.getIncomeSummary()==null){
                incomeStatementBean.setIncomeSummary("0");
            }
        }*/
        datasetBeanMapper.beansToDataset(resData, incomeStatementList, IncomeStatementBean.class);

        return null;

       /* System.out.println("accountPeriodNo = " + accountPeriodNo+callResult);
        HashMap<String, Object> param = new HashMap<>();
        param.put("accountPeriodNo", accountPeriodNo);
        param.put("callResult", callResult);
        statementServiceFacade.getIncomeStatement(param);
        System.out.println("incomeParam = " + param);
        return param;*/
    }
}

