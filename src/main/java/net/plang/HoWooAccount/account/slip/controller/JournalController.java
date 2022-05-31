package net.plang.HoWooAccount.account.slip.controller;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.HoWooAccount.account.slip.entity.JournalEntity;
import net.plang.HoWooAccount.account.slip.serviceFacade.SlipServiceFacade;
import net.plang.HoWooAccount.account.slip.to.JournalBean;
import net.plang.HoWooAccount.system.common.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@RestController
public class JournalController {

    @Autowired
    private SlipServiceFacade slipServiceFacade;

    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping(value = "SpringBoot_Account/account/slip/findRangedJournalList")
    public ArrayList<JournalBean> getRangedJournalList(@RequestAttribute("reqData") PlatformData reqData, @RequestAttribute("resData") PlatformData resData) throws Exception{
        String fromDate = reqData.getVariable("from").getString();
        String toDate = reqData.getVariable("to").getString();

        HashMap<String, String> param = new HashMap<>();
        param.put("fromDate", fromDate);
        param.put("toDate", toDate);

        ArrayList<JournalBean> journalList=slipServiceFacade.getRangedJournalList(param);

        datasetBeanMapper.beansToDataset(resData, journalList, JournalBean.class);
        return null;
    }

    @RequestMapping(value = "SpringBoot_Account/account/slip/findSingleJournalList")
    public ArrayList<JournalBean> findSingleJournalList(@RequestAttribute("reqData") PlatformData reqData,
                                                          @RequestAttribute("resData") PlatformData resData) throws Exception {

        String slipNo = reqData.getVariable("slipNo").getString(); //클릭한 전표

        ArrayList<JournalBean> journalList = slipServiceFacade.findSingleJournalList(slipNo);

        datasetBeanMapper.beansToDataset(resData, journalList, JournalBean.class);

        return null;
    }

    @GetMapping("/deleteJournal")
    public void deleteJournal(@RequestParam String journalNo) {
        slipServiceFacade.deleteJournal(journalNo);
    }

    @RequestMapping(value = "SpringBoot_Account/account/slip/findRangedDetailJournalList")
    public HashMap<String,Object> findRangedDetailJournalList(@RequestAttribute("reqData") PlatformData reqData,
                                                              @RequestAttribute("resData") PlatformData resData) throws Exception {


        String fromDate = reqData.getVariable("fromDate").getString();
        String toDate = reqData.getVariable("toDate").getString();
        String accountName = reqData.getVariable("accountName").getString(); //계정별

        HashMap<String,Object> map = new HashMap<>();
        map.put("toDate", toDate);
        map.put("fromDate", fromDate);
        map.put("accountName", accountName);

        ArrayList<JournalBean> journalDetailList= slipServiceFacade.findRangedDetailJournalList(map);

        datasetBeanMapper.beansToDataset(resData, journalDetailList, JournalBean.class);

        return null;
    }
}
