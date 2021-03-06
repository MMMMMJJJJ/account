package net.plang.HoWooAccount.system.base.applicationService;

import net.plang.HoWooAccount.account.base.repository.PeriodRepository;
import net.plang.HoWooAccount.account.base.to.PeriodBean;
import net.plang.HoWooAccount.hr.affair.mapper.EmployeeDAO;
import net.plang.HoWooAccount.hr.affair.repository.EmployeeRepository;
import net.plang.HoWooAccount.hr.affair.to.EmployeeBean;
import net.plang.HoWooAccount.system.base.mapper.MenuDAO;
import net.plang.HoWooAccount.system.base.mapper.PeriodDAO;
import net.plang.HoWooAccount.system.base.exception.DeptCodeNotFoundException;
import net.plang.HoWooAccount.system.base.exception.IdNotFoundException;
import net.plang.HoWooAccount.system.base.exception.PwMissmatchException;
import net.plang.HoWooAccount.system.base.to.IreportBean;
import net.plang.HoWooAccount.system.base.to.MenuBean;
import net.plang.HoWooAccount.system.common.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class BaseApplicationServiceImpl implements BaseApplicationService {

    @Autowired
    private MenuDAO menuDAO;
    @Autowired
    private PeriodDAO periodDAO;
    @Autowired
    private PeriodRepository periodRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    public void setEarlyStatements(String periodNo) {

        try {
           periodDAO.setEarlyStatements(periodNo);

        } catch (DataAccessException e) {
            throw e;

        }
    }
    
    public String getPeriodNo(String today) {

        String periodNo = periodDAO.getPeriodNo(today);

        return periodNo;
    }

    @Override
    public ArrayList<PeriodBean> getPeriodNoList(){

        ArrayList<PeriodBean> periodNoList = (ArrayList<PeriodBean>) periodRepository.findAll();

        return periodNoList;

    }

    public void insertPeriodNo(String sdate,String edate) {

        try {
           periodDAO.insertPeriodNo(sdate,edate);

        } catch (DataAccessException e) {
            throw e;

        }
    }
    
    //??????????????? ?????????
    @Override
    public ArrayList<IreportBean> getIreportData(String slipNo) {

        ArrayList<IreportBean> reportDataList = null;
        try {
           System.out.println("??????????????? ??????????????????");

        } catch (DataAccessException e) {
            throw e;

        }
        return reportDataList;
    }


    @Override
    public EmployeeBean getLoginData(String empCode, String userPw) throws IdNotFoundException, DeptCodeNotFoundException, PwMissmatchException, DataAccessException {

        EmployeeBean employeeBean = null;

        try {
            Optional<EmployeeBean> op=employeeRepository.findById(empCode);

            if(op.isPresent()){ //get??? ?????? ??? ???????????? ?????? ?????? ??????.
                employeeBean = op.get();
                if (!employeeBean.getUserPw().equals(userPw))
                    throw new PwMissmatchException("??????????????? ????????????.");
            }
            //employeeBean = employeeDAO.selectEmployee(empCode);
            return employeeBean;

        } catch (NoSuchElementException e) {
            throw new IdNotFoundException("?????? ?????? ?????? ???????????????.");
        }

    }

    @Override
    public ArrayList<MenuBean> findMenuNameList(String deptCode) {

        ArrayList<MenuBean> menuList = null;
        try {
            menuList = menuDAO.selectMenuNameList(deptCode);
        } catch (DataAccessException e) {
            throw e;

        }
        return menuList;
    }
}