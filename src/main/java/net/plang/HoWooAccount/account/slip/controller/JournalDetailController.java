package net.plang.HoWooAccount.account.slip.controller;


import com.tobesoft.xplatform.data.PlatformData;
import net.plang.HoWooAccount.account.slip.serviceFacade.SlipServiceFacade;
import net.plang.HoWooAccount.account.slip.to.JournalDetailBean;
import net.plang.HoWooAccount.system.common.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController

public class JournalDetailController {

    @Autowired
    private SlipServiceFacade slipServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping(value = "SpringBoot_Account/account/slip/getJournalDetailList")
    public ArrayList<JournalDetailBean> getJournalDetailList(@RequestAttribute("reqData") PlatformData reqData, @RequestAttribute("resData") PlatformData resData) throws Exception{

        String journalNo = reqData.getVariable("journalNo").getString();

        ArrayList<JournalDetailBean> JournalDetailList =slipServiceFacade.getJournalDetailList(journalNo);
        datasetBeanMapper.beansToDataset(resData, JournalDetailList, JournalDetailBean.class);

        return null;
    }

    @GetMapping("/editJournalDetail")
    public HashMap<String, String> editJournalDetail(@ModelAttribute JournalDetailBean journalDetailBean) {

        HashMap<String, String> map = new HashMap<>();
        String accountControlType = journalDetailBean.getAccountControlType();
        String journalDescription;

        journalDetailBean.setAccountControlType(accountControlType);

        String dName = slipServiceFacade.editJournalDetail(journalDetailBean);

        Boolean findSelect = accountControlType.equals("SELECT");
        Boolean findSearch = accountControlType.equals("SEARCH");

        if(findSelect || findSearch) {
            journalDescription=dName;

            map.put("accountControlType", accountControlType);
            map.put("journalDescription", journalDescription);
        }

        return map;
    }
}
