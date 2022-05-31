package net.plang.HoWooAccount.system.base.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tobesoft.xplatform.data.PlatformData;
import net.plang.HoWooAccount.system.base.serviceFacade.BaseServiceFacade;
import net.plang.HoWooAccount.system.base.to.CodeBean;
import net.plang.HoWooAccount.system.base.to.CodeDetailBean;
import net.plang.HoWooAccount.system.base.to.CustomerBean;
import net.plang.HoWooAccount.system.base.to.DetailCodeBean;
import net.plang.HoWooAccount.system.common.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class CodeListController {
    @Autowired
    private BaseServiceFacade baseServiceFacade;

    @Autowired
    DatasetBeanMapper datasetBeanMapper;

    @GetMapping("/getDetailCodeList")
    public ArrayList<DetailCodeBean> getDetailCodeList(@RequestParam String divisionCodeNo, @RequestParam String detailCodeName) {
        HashMap<String, String> param = new HashMap<>();
        param.put("divisionCodeNo", divisionCodeNo);
        if (detailCodeName != null)
            param.put("detailCodeName", detailCodeName);
        return baseServiceFacade.getDetailCodeList(param);

    }

    @RequestMapping(value = "SpringBoot_Account/base/CodeList")
    public void findCodeList(@RequestAttribute("reqData") PlatformData reqData,@RequestAttribute("resData") PlatformData resData) throws Exception {//리턴형 필요 없는거 아님?

        ArrayList<CodeBean> resultList =  baseServiceFacade.findCodeList();
        datasetBeanMapper.beansToDataset(resData, resultList, CodeBean.class);

    }

    @RequestMapping(value = "SpringBoot_Account/base/CodeDetailList")
    public ArrayList<CodeBean> findCodeDetailList(@RequestAttribute("reqData") PlatformData reqData, @RequestAttribute("resData") PlatformData resData)throws Exception{
        ArrayList<CodeDetailBean> resultList =  baseServiceFacade.findCodeDetailList();
        datasetBeanMapper.beansToDataset(resData, resultList, CodeDetailBean.class);
        return null;
    }

    @GetMapping("/batchCodeProcess")
    public void batchCodeProcess(@RequestParam String batchList, @RequestParam String batchList2) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<CodeBean> codeList = mapper.readValue(batchList, new TypeReference<ArrayList<CodeBean>>() {
            });
            ArrayList<DetailCodeBean> codeList2 = mapper.readValue(batchList2,
                    new TypeReference<ArrayList<DetailCodeBean>>() {
                    });
            baseServiceFacade.batchCodeProcess(codeList, codeList2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "SpringBoot_Account/base/CustomerCodeList")
    public ArrayList<CustomerBean> findCustomerCodeList(@RequestAttribute("reqData") PlatformData reqData, @RequestAttribute("resData") PlatformData resData) throws Exception {
        System.out.println("어디서 에러가 나니...? CustomerCodeList시작.");
        ArrayList<CustomerBean> resultList =  baseServiceFacade.findCustomerList();

        datasetBeanMapper.beansToDataset(resData, resultList, CustomerBean.class);

        return null;
    }
}
