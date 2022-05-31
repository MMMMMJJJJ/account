package net.plang.HoWooAccount.account.slip.controller;

import com.google.gson.Gson;
import com.tobesoft.xplatform.data.PlatformData;
import net.plang.HoWooAccount.account.slip.entity.JournalDetailEntity;
import net.plang.HoWooAccount.account.slip.entity.JournalEntity;
import net.plang.HoWooAccount.account.slip.entity.SlipEntity;
import net.plang.HoWooAccount.account.slip.serviceFacade.SlipServiceFacade;
import net.plang.HoWooAccount.account.slip.to.JournalBean;
import net.plang.HoWooAccount.account.slip.to.JournalDetailBean;
import net.plang.HoWooAccount.account.slip.to.SlipBean;
import net.plang.HoWooAccount.system.common.mapper.DatasetBeanMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

@RestController
public class SlipController {

    @Autowired
    private SlipServiceFacade slipServiceFacade;

    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    //전표 조회
    @RequestMapping(value = "SpringBoot_Account/account/slip/findRangedSlipList")
    public void findRangedSlipList(@RequestAttribute("reqData") PlatformData reqData, @RequestAttribute("resData") PlatformData resData) throws Exception{

        String from = reqData.getVariable("startDate").getString(); // 21-06-26
        String to = reqData.getVariable("endDate").getString();
        String slipStatus = reqData.getVariable("slipStatus").getString(); // 검색조건

        HashMap<String,String> param = new HashMap<>();
        param.put("from",from);
        param.put("to",to);
        param.put("slipStatus",slipStatus);

        //ErrorCode 담아서 보내지도 않기 때문에 HashMap으로 받을 필요 없음.
        ArrayList<SlipBean> slipList = slipServiceFacade.findRangedSlipList(param);

        datasetBeanMapper.beansToDataset(resData, slipList, SlipBean.class);

    }

    @PostMapping("/updateSlip")
    public String updateSlip(@RequestParam String slipObj, @RequestParam String journalObj, @RequestParam String slipStatus) {

        Gson gson = new Gson();
        JSONObject slipJson = JSONObject.fromObject(slipObj); //전표
        JSONArray journalJson = JSONArray.fromObject(journalObj); //분개
        SlipBean slipBean = gson.fromJson(slipObj.toString(), SlipBean.class);
        ArrayList<JournalBean> journalBeans = new ArrayList<>();
        for (Object journal : journalJson) {
            JournalBean journalBean = gson.fromJson(journal.toString(), JournalBean.class);

            journalBean.setSlipNo(slipBean.getSlipNo());
            journalBeans.add(journalBean);
        }

        if(slipStatus.equals("승인요청")) {
            slipBean.setSlipStatus("승인요청");
        }else if(slipStatus.equals("작성중(반려)")){
            slipBean.setSlipStatus("승인요청");
        }
        return slipServiceFacade.updateSlip(slipBean,journalBeans);
    }

    //전표 저장
    @RequestMapping(value="SpringBoot_Account/account/slip/addSlip")
    public String addSlip(@RequestAttribute("reqData") PlatformData reqData,
                          @RequestAttribute("resData") PlatformData resData) throws Exception {

        // 넘어온 dataset 데이터를 Bean객체로 파싱
        SlipEntity slipObj = datasetBeanMapper.datasetToBean(reqData, SlipEntity.class); // 전표추가는 한번에 하나 가능

        ArrayList<JournalEntity> journal = (ArrayList<JournalEntity>)datasetBeanMapper.datasetToBeans(reqData, JournalEntity.class); // 분개
        ArrayList<JournalDetailEntity> journalDetail = (ArrayList<JournalDetailEntity>)datasetBeanMapper.datasetToBeans(reqData, JournalDetailEntity.class); // 분개상세

        String empCode = reqData.getVariable("empCode").getString();
        String deptCode = reqData.getVariable("deptCode").getString();

        slipObj.setReportingEmpCode(empCode);
        slipObj.setDeptCode(deptCode);
        slipObj.setSlipStatus("승인요청");

        System.out.println("view에서 넘어온 Data");
        System.out.println(slipObj.getReportingDate());
        System.out.println(slipObj.getAccountPeriodNo());
        System.out.println(slipObj.getApprovalDate());
        System.out.println(slipObj.getAuthorizationStatus());
        System.out.println(slipObj.getDeptCode());
        System.out.println(slipObj.getApprovalEmpCode());
        System.out.println(slipObj.getExpenseReport());
        System.out.println(slipObj.getReportingEmpCode());
        System.out.println(slipObj.getReportingDate());
        System.out.println(slipObj.getSlipDescription());
        System.out.println(slipObj.getSlipNo());
        System.out.println(slipObj.getSlipStatus());

        slipServiceFacade.addSlip(slipObj, journal, journalDetail);

        return null;
    }

    @RequestMapping(value = "SpringBoot_Account/account/slip/deleteSlip")
    public  void deleteSlip(@RequestAttribute("reqData") PlatformData reqData,
                            @RequestAttribute("resData") PlatformData resData) throws Exception {
        String slipNo = reqData.getVariable("slipNo").getString();
        slipServiceFacade.deleteSlip(slipNo);
    }

    @RequestMapping(value = "SpringBoot_Account/account/slip/approveSlip")
    public void approveSlip(@RequestAttribute("reqData") PlatformData reqData,
                              @RequestAttribute("resData") PlatformData resData) throws Exception {

        ArrayList<SlipEntity> slipList = (ArrayList<SlipEntity>)datasetBeanMapper.datasetToBeans(reqData, SlipEntity.class);

        slipServiceFacade.approveSlip(slipList);
    }

    @RequestMapping(value = "SpringBoot_Account/account/slip/findDisApprovalSlipList")
    public ArrayList<SlipEntity> findDisApprovalSlipList(@RequestAttribute("reqData") PlatformData reqData,
                                                         @RequestAttribute("resData") PlatformData resData) throws Exception{
        String from = reqData.getVariable("startDate").getString();
        String to = reqData.getVariable("endDate").getString();

        ArrayList <SlipEntity> slipList = slipServiceFacade.findDisApprovalSlipList(from,to);

        datasetBeanMapper.beansToDataset(resData, slipList, SlipEntity.class);
        return null;
    }

    @GetMapping("/callAccountingSettlementStatus")
    public HashMap<String, Object> callAccountingSettlementStatus(@RequestParam String accountPeriodNo, @RequestParam String callResult) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("accountPeriodNo", accountPeriodNo);
        param.put("callResult", callResult);
        slipServiceFacade.getAccountingSettlementStatus(param);
        return param;
    }
}