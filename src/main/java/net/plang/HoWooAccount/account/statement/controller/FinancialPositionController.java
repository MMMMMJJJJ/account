package net.plang.HoWooAccount.account.statement.controller;

import com.tobesoft.xplatform.data.PlatformData;
import lombok.Setter;
import net.plang.HoWooAccount.account.statement.serviceFacade.StatementServiceFacade;
import net.plang.HoWooAccount.account.statement.to.FinancialPositionBean;
import net.plang.HoWooAccount.system.common.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;


@RestController
public class FinancialPositionController {

    @Autowired
    private StatementServiceFacade statementServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping(value = "SpringBoot_Account/account/statement/financialPosition")
    public HashMap<String, Object> financialPosition(@RequestAttribute("reqData") PlatformData reqData,
                                                     @RequestAttribute("resData") PlatformData resData) throws Exception{
        String accountPeriodNo = reqData.getVariable("periodNo").getString();  //기수번호
        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("accountPeriodNo",accountPeriodNo);
        paramMap.put("callResult","SEARCH");


        HashMap<String,Object> resultMap = statementServiceFacade.getFinancialPosition(paramMap);  //프로시저 P_FINANCIAL_POSITION

        ArrayList<FinancialPositionBean> financialPositionList = (ArrayList<FinancialPositionBean>)resultMap.get("financialPosition");

        datasetBeanMapper.beansToDataset(resData, financialPositionList, FinancialPositionBean.class);

        return null;
    }
}

