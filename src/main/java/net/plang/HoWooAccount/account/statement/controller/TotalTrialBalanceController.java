package net.plang.HoWooAccount.account.statement.controller;

import com.google.gson.Gson;
import com.tobesoft.xplatform.data.PlatformData;
import net.plang.HoWooAccount.account.statement.serviceFacade.StatementServiceFacade;
import net.plang.HoWooAccount.account.statement.to.TotalTrialBalanceBean;
import net.plang.HoWooAccount.system.common.exception.DataAccessException;
import net.plang.HoWooAccount.system.common.mapper.DatasetBeanMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class TotalTrialBalanceController {

    @Autowired
    private StatementServiceFacade statementServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @GetMapping("/doClosing")
    public HashMap<String, Object> doClosing(@RequestParam String accountPeriodNo, @RequestParam String callResult) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("accountPeriodNo", accountPeriodNo);
        param.put("callResult", callResult);
        statementServiceFacade.getEarlyStatements(param);
        System.out.println("ClosingParam = " + param);
        return param;
    }

    @RequestMapping("SpringBoot_Account/account/statement/showTotalTrialBalance")
    public void showTotalTrialBalance(@RequestAttribute("reqData") PlatformData reqData,
                                                         @RequestAttribute("resData") PlatformData resData)throws Exception{

        String accountPeriodNo = reqData.getVariable("periodNo").getString();   //선택한 기수-6
        HashMap<String,Object> paramMap= new HashMap<>();
        paramMap.put("accountPeriodNo",accountPeriodNo);
        paramMap.put("callResult","SEARCH");

        System.out.println("프로시저 호출 전");
        HashMap<String, Object> resultMap =  statementServiceFacade.getTotalTrialBalance(paramMap);  //프로시저 P_TOTAL_TRIAL_BALANCE(기수,?,?,?)
        System.out.println("프로시저 호출 후");

        ArrayList<TotalTrialBalanceBean> totalTrialBalanceList = (ArrayList<TotalTrialBalanceBean>)resultMap.get("totalTrialBalance");
        System.out.println("보낼 값.");
        for(TotalTrialBalanceBean total:totalTrialBalanceList){
            System.out.println(total.getAccountInnerCode());
            System.out.println(total.getAccountName());
            System.out.println(total.getCreditsSum());
            System.out.println(total.getCreditsSumBalance());
            System.out.println(total.getDebitsSum());
            System.out.println(total.getDebitsSumBalance());
            System.out.println(total.getLev());

        }
        datasetBeanMapper.beansToDataset(resData, totalTrialBalanceList, TotalTrialBalanceBean.class);
    }

    @GetMapping("/cancelClosing")
    public HashMap<String, Object> cancelClosing(@RequestParam String accountPeriodNo, @RequestParam String callResult) {

        HashMap<String, Object> param = new HashMap<>();
        param.put("accountPeriodNo", accountPeriodNo);
        param.put("callResult", callResult);
        statementServiceFacade.changeAccountingSettlement(param);
        System.out.println("ClosingParam = " + param);
        return param;
    }

    @RequestMapping(value = "SpringBoot_Account/account/statement/executeSettlement")
    public HashMap<String, Object> executeSettlement(@RequestAttribute("reqData") PlatformData reqData,
                                                     @RequestAttribute("resData") PlatformData resData) throws Exception {

        String accountPeriodNo = reqData.getVariable("periodNo").getString();
        statementServiceFacade.insertEarlyStatements(accountPeriodNo);

        return null;
    }
}






