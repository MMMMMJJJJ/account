package net.plang.HoWooAccount.system.base.controller;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.HoWooAccount.account.base.to.PeriodBean;
import net.plang.HoWooAccount.hr.affair.to.EmployeeBean;
import net.plang.HoWooAccount.system.base.exception.IdNotFoundException;
import net.plang.HoWooAccount.system.base.exception.PwMissmatchException;
import net.plang.HoWooAccount.system.base.serviceFacade.BaseServiceFacade;
import net.plang.HoWooAccount.system.base.to.MenuBean;
import net.plang.HoWooAccount.system.common.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class MemberLoginController {
    @Autowired
    private BaseServiceFacade baseServiceFacade;

    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @SuppressWarnings("unchecked")
    @RequestMapping("SpringBoot_Account/base/login")
    public ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest , @RequestAttribute("reqData") PlatformData reqData, @RequestAttribute("resData") PlatformData resData) throws Exception{
        HttpSession session = httpServletRequest.getSession();

        String empCode = reqData.getVariable("empCode").getString(); // Variable객체를 String으로 변환
        String userPw = reqData.getVariable("userPw").getString();
        String today = reqData.getVariable("today").getString();
        System.out.println("xplatform 에서 넘겨받은 값들 empCode: "+empCode+" userPw : "+userPw+" today: "+today);

        EmployeeBean employeeBean = baseServiceFacade.getLoginData(empCode, userPw);

        //회계기수를 반환함. 오늘날짜가 period기수정보 테이블에 없으면 null
        String periodNo=baseServiceFacade.getPeriodNo(today);

        //현재 날짜에 해당하는 기수번호가 없을 경우 생성.
        if(periodNo==null) {
            String[] str=today.split("-");   // str={"2020","02","05"}
            String sdate=str[0]+"-"+"01-01";
            String edate=str[0]+"-"+"12-31";

            baseServiceFacade.insertPeriodNo(sdate,edate);	// sdate=20200101 sdate=20201231
            periodNo=baseServiceFacade.getPeriodNo(today);
            baseServiceFacade.setEarlyStatements(periodNo);
        }
        ArrayList<PeriodBean> periodNoList = baseServiceFacade.getPeriodNoList();

        datasetBeanMapper.beanToDataset(resData, employeeBean, EmployeeBean.class);
        datasetBeanMapper.beansToDataset(resData, periodNoList, PeriodBean.class);

        /*
        session.setAttribute("periodNo", periodNo);

        if (employeeBean != null) {

            session.setAttribute("empCode", employeeBean.getEmpCode());
            session.setAttribute("empName", employeeBean.getEmpName());
            session.setAttribute("deptCode", employeeBean.getDeptCode());
            session.setAttribute("deptName", employeeBean.getDeptName());
            session.setAttribute("empProfileImg", employeeBean.getImage());
            session.setAttribute("positionName", employeeBean.getPositionName());

            viewName = "redirect:hello.html";
        }
        */

        //계정별 메뉴 권한
        /*
         * ArrayList<AuthorityEmpBean> authorityEmp = baseServiceFacade.getAuthority(empCode);
         * ArrayList<String> list = new ArrayList<String>();
         * for(AuthorityEmpBean obj: authorityEmp){
         * list.add(obj.getIsAuthority()); } session.setAttribute("list", list);
         */

        /*
        // 부서별 메뉴 권한
        ArrayList<MenuBean> menuList = baseServiceFacade.findUserMenuList(employeeBean.getDeptCode());

        ArrayList<String> list = new ArrayList<>();

        for(MenuBean menu : menuList) {
            list.add(menu.getMenuName());
        }

        session.setAttribute("menuList", list);
        */

        return null;
    }

}