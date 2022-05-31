package net.plang.HoWooAccount.hr.affair.serviceFacade;

import java.util.ArrayList;

import net.plang.HoWooAccount.hr.affair.to.DepartmentBean;
import net.plang.HoWooAccount.hr.affair.to.EmployeeBean;

public interface HRServiceFacade {

    public ArrayList<EmployeeBean> findEmployeeList();

    public ArrayList<EmployeeBean> findAllEmployeeList();

    public EmployeeBean findEmployee(String empCode);

    public void batchEmployeeInfo(EmployeeBean employeeBean);

    public void registerEmployee(EmployeeBean employeeBean);

    public void removeEmployee(String empCode);

    public ArrayList<DepartmentBean> findDeptList();

    public ArrayList<DepartmentBean> findDetailDeptList(String workplaceCode);
}
