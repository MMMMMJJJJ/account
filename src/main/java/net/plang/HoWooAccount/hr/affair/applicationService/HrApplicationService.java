package net.plang.HoWooAccount.hr.affair.applicationService;

import java.util.ArrayList;

import net.plang.HoWooAccount.hr.affair.to.DepartmentBean;
import net.plang.HoWooAccount.hr.affair.to.EmployeeBean;

public interface HrApplicationService {
    public ArrayList<EmployeeBean> findEmployeeList();

    public EmployeeBean findEmployee(String empCode);

    public void batchEmployeeInfo(EmployeeBean employeeBean);

    public void registerEmployee(EmployeeBean employeeBean);

    public void removeEmployee(String empCode);

    public ArrayList<DepartmentBean> findDeptList();

    public ArrayList<DepartmentBean> findDetailDeptList(String workplaceCode);

    public ArrayList<EmployeeBean> findAllEmployeeList();
}
