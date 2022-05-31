package net.plang.HoWooAccount.hr.affair.controller;

import com.google.gson.Gson;
import com.tobesoft.xplatform.data.PlatformData;
import net.plang.HoWooAccount.hr.affair.serviceFacade.HRServiceFacade;
import net.plang.HoWooAccount.hr.affair.to.DepartmentBean;
import net.plang.HoWooAccount.hr.affair.to.EmployeeBean;
import net.plang.HoWooAccount.system.common.exception.DataAccessException;
import net.plang.HoWooAccount.system.common.mapper.DatasetBeanMapper;
import net.plang.HoWooAccount.system.common.util.FileUploader;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class HRController {

    @Autowired
    private HRServiceFacade hrServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping(value = "SpringBoot_Account/hr/findEmployeeList")
    public ArrayList<EmployeeBean> findEmployeeList(@RequestAttribute("reqData") PlatformData reqData,
                                                    @RequestAttribute("resData") PlatformData resData) throws Exception{
        ArrayList<EmployeeBean> empList = hrServiceFacade.findEmployeeList();
        datasetBeanMapper.beansToDataset(resData, empList,EmployeeBean.class);
        return null;
    }

    @GetMapping("/findEmployeeList1")
    public ArrayList<EmployeeBean> findEmployeeList1(HttpServletRequest request, HttpServletResponse response) {
        return hrServiceFacade.findAllEmployeeList();
    }

    @PostMapping("/findEmployee")
    public EmployeeBean findEmployee(@RequestParam(value="empCode") String empCode) {
        return hrServiceFacade.findEmployee(empCode);
    }

    @RequestMapping(value = "SpringBoot_Account/hr/batchEmpInfo")
    public void batchEmpInfo(@RequestAttribute("reqData") PlatformData reqData,
                                     @RequestAttribute("resData") PlatformData resData) throws Exception {
        EmployeeBean empBean = datasetBeanMapper.datasetToBean(reqData, EmployeeBean.class);
        hrServiceFacade.batchEmployeeInfo(empBean);
    }

    @RequestMapping(value = "SpringBoot_Account/hr/deleteEmployee")
    public void batchEmp(@RequestAttribute("reqData") PlatformData reqData,
                         @RequestAttribute("resData") PlatformData resData) throws Exception {
        String empCode = reqData.getVariable("empCode").getString();

        hrServiceFacade.removeEmployee(empCode);
    }

    @RequestMapping(value = "SpringBoot_Account/hr/saveEmpImg")
    public void saveEmployeeImage(@RequestAttribute("reqData") PlatformData reqData) throws Exception{
        FileUploader.uploadFile(reqData, "emp");
    }

    @GetMapping("/deleteEmployee")
    public void deleteEmployee(@ModelAttribute EmployeeBean employeeBean) {
        hrServiceFacade.removeEmployee(employeeBean.getEmpCode());
    }

    @GetMapping("/findDeptList")
    public ArrayList<DepartmentBean> findDeptList() {
        return hrServiceFacade.findDeptList();
    }

    @GetMapping("/findDetailDeptList")
    public ArrayList<DepartmentBean> findDetailDeptList(@RequestParam String workplaceCode) {
        return hrServiceFacade.findDetailDeptList(workplaceCode);
    }

}
