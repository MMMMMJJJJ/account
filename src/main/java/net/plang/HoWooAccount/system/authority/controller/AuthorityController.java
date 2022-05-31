package net.plang.HoWooAccount.system.authority.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tobesoft.xplatform.data.PlatformData;
import net.plang.HoWooAccount.system.authority.serviceFacade.AuthorityServiceFacade;
import net.plang.HoWooAccount.system.authority.to.AuthorityBean;
import net.plang.HoWooAccount.system.authority.to.AuthorityEmpBean;
import net.plang.HoWooAccount.system.authority.to.AuthorityMenuBean;
import net.plang.HoWooAccount.system.common.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class AuthorityController {
    @Autowired
    private AuthorityServiceFacade authorityServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @GetMapping("/findAuthorityEmp")
    public ArrayList<AuthorityEmpBean> findAuthorityEmp(@RequestParam String deptCode) {
        return authorityServiceFacade.findAuthorityEmp(deptCode);
    }

    @PutMapping("/editAuthority")
    public void editAuthority(@RequestParam String authority, @RequestParam String dept) {

        Gson gson = new Gson();
        ArrayList<AuthorityEmpBean> authorityEmpBean =
                gson.fromJson(authority, new TypeToken<ArrayList<AuthorityEmpBean>>() {
                }.getType());
        authorityServiceFacade.updateAuthority(authorityEmpBean, dept);

    }

    @RequestMapping(value = "SpringBoot_Account/hr/loginAuthority")
    public void loginAuthority(@RequestAttribute("reqData") PlatformData reqData, @RequestAttribute("resData") PlatformData resData)throws Exception{
        String empCode = reqData.getVariable("empCode").getString();
        ArrayList<AuthorityMenuBean> authorityList = authorityServiceFacade.findEmpAuthorityList(empCode);

        datasetBeanMapper.beansToDataset(resData, authorityList, AuthorityMenuBean.class);
    }

    //권한관리>권한설정  onload
    @RequestMapping(value = "SpringBoot_Account/hr/authorityEmp")
    public HashMap<String, Object> authorityEmp(@RequestAttribute("reqData") PlatformData reqData,
                                                @RequestAttribute("resData") PlatformData resData) throws Exception {

        ArrayList<AuthorityEmpBean> authorityList = authorityServiceFacade.findAuthorityEmpList();

        datasetBeanMapper.beansToDataset(resData, authorityList, AuthorityEmpBean.class);
        return null;
    }

    //권한관리>메뉴설정 onload
    @RequestMapping(value = "SpringBoot_Account/hr/authority")
    public HashMap<String, Object> authority(@RequestAttribute("reqData") PlatformData reqData,
                                             @RequestAttribute("resData") PlatformData resData) throws Exception {

        ArrayList<AuthorityBean> authorityList = authorityServiceFacade.findAuthorityList();

        datasetBeanMapper.beansToDataset(resData, authorityList, AuthorityBean.class);
        return null;
    }

    //권한관리>메뉴설정 onload
    @RequestMapping(value = "SpringBoot_Account/hr/authorityMenu")
    public HashMap<String, Object> authorityMenu(@RequestAttribute("reqData") PlatformData reqData,
                                                 @RequestAttribute("resData") PlatformData resData) throws Exception {

        ArrayList<AuthorityMenuBean> authorityMenuList = authorityServiceFacade.findAuthorityMenuList();

        datasetBeanMapper.beansToDataset(resData, authorityMenuList, AuthorityMenuBean.class);
        return null;
    }
}
