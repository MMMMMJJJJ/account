package net.plang.HoWooAccount.account.base.controller;

import com.tobesoft.xplatform.data.PlatformData;
import lombok.Setter;
import net.plang.HoWooAccount.account.base.Entity.AccountControlDetailEntity;
import net.plang.HoWooAccount.account.base.serviceFacade.AccountServiceFacade;
import net.plang.HoWooAccount.account.base.to.*;
import net.plang.HoWooAccount.system.common.exception.DataAccessException;
import net.plang.HoWooAccount.system.common.mapper.DatasetBeanMapper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountServiceFacade accountServiceFacade;

    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @GetMapping("/getAccount")
    public AccountBean getAccount(@RequestParam String accountCode) {
        return accountServiceFacade.getAccount(accountCode);
    }

    @RequestMapping(value = "SpringBoot_Account/account/base/getAccountControlList")
    public ArrayList<AccountControlDetailBean> getAccountControlList(@RequestAttribute("reqData") PlatformData reqData,
                                                               @RequestAttribute("resData") PlatformData resData) throws Exception {


        String accountCode = reqData.getVariable("accountCode").getString(); // 계정 정보
        ArrayList<AccountControlDetailBean> controlDetailList = accountServiceFacade.getAccountControlList(accountCode);

        datasetBeanMapper.beansToDataset(resData, controlDetailList, AccountControlDetailBean.class);

        return null;
    }

    @RequestMapping(value = "SpringBoot_Account/account/base/getAccountList")
    public ArrayList<AccountBean> getAccountList(@RequestAttribute("reqData") PlatformData reqData, @RequestAttribute("resData") PlatformData resData) throws Exception{

        String accountName = reqData.getVariable("accountName").getString();

        ArrayList<AccountBean> accountList = accountServiceFacade.getAccountList(accountName);

        datasetBeanMapper.beansToDataset(resData, accountList, AccountBean.class);
        return null;
    }

    @GetMapping("/findParentAccountList")
    public ArrayList<AccountBean> findParentAccountList() {
        return accountServiceFacade.findParentAccountList();
    }

    @GetMapping("/findDetailAccountList")
    public ArrayList<AccountBean> findDetailAccountList(@RequestParam String code) {
        return accountServiceFacade.findDetailAccountList(code);
    }

    @RequestMapping(value = "SpringBoot_Account/account/base/findDetailBudgetList")
    public ArrayList<AccountBean> findDetailBudgetList(@RequestAttribute("reqData") PlatformData reqData,
                                                     @RequestAttribute("resData") PlatformData resData) throws Exception {

        String code = reqData.getVariable("code").getString();
        System.out.println("xplatform 받은 데이터 " + code);
        ArrayList<AccountControlDetailEntity> budgetDetailList = accountServiceFacade.findDetailBudgetList(code);
        datasetBeanMapper.beansToDataset(resData, budgetDetailList, AccountControlDetailEntity.class);
        return null;
    }

    @RequestMapping(value = "SpringBoot_Account/account/base/findParentBudgetList")
    public ArrayList<AccountBean> findParentBudgetList(@RequestAttribute("reqData") PlatformData reqData,
                                                     @RequestAttribute("resData") PlatformData resData) throws Exception {

        ArrayList<AccountBean> budgetList = accountServiceFacade.findParentBudgetList();

        datasetBeanMapper.beansToDataset(resData, budgetList, AccountBean.class);
        return null;
    }

    @GetMapping("/findAccountPeriodList")
    public ArrayList<PeriodBean> findAccountPeriodList() {
        return accountServiceFacade.findAccountPeriodList();
    }

    @RequestMapping(value = "SpringBoot_Account/account/base/accountControlDetail")
    public ArrayList<AccountControlDetailBean> selectAccountControl(@RequestAttribute("reqData") PlatformData reqData, @RequestAttribute("resData") PlatformData resData) throws Exception {

        System.out.println("@@@@@@@로그인 후 일반전표 누를때 실행");
        ArrayList<AccountControlDetailBean> controlDetail = accountServiceFacade.getAccountControlDetail();

        datasetBeanMapper.beansToDataset(resData, controlDetail, AccountControlDetailBean.class);

        return null;
    }

    //기초정보관리>계정과목관리
    //장부관리>계정별원장
    @RequestMapping(value = "SpringBoot_Account/account/base/AccountCodeList")
    public ArrayList<AccountCodeBean> findAccountCodeList(@RequestAttribute("reqData") PlatformData reqData,
                                                          @RequestAttribute("resData") PlatformData resData) throws Exception {

        ArrayList<AccountCodeBean> accountCodeList = accountServiceFacade.getAccountList();
        datasetBeanMapper.beansToDataset(resData, accountCodeList, AccountCodeBean.class);
        return null;
    }
}
