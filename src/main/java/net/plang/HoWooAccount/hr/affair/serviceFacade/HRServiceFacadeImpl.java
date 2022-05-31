package net.plang.HoWooAccount.hr.affair.serviceFacade;

import net.plang.HoWooAccount.hr.affair.applicationService.HrApplicationService;
import net.plang.HoWooAccount.hr.affair.to.DepartmentBean;
import net.plang.HoWooAccount.hr.affair.to.EmployeeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HRServiceFacadeImpl implements HRServiceFacade {

    @Autowired
    private HrApplicationService hrApplicationService;

    @Override
    public EmployeeBean findEmployee(String empCode) {
        return hrApplicationService.findEmployee(empCode);
    }

    @Override
    public ArrayList<EmployeeBean> findEmployeeList() {
        return hrApplicationService.findEmployeeList();
    }
    
    @Override
    public ArrayList<EmployeeBean> findAllEmployeeList() {
        return hrApplicationService.findAllEmployeeList();
    }

    @Override
    public void batchEmployeeInfo(EmployeeBean employeeBean) {
        hrApplicationService.batchEmployeeInfo(employeeBean);
    }

    @Override
    public void registerEmployee(EmployeeBean employeeBean) {
        hrApplicationService.registerEmployee(employeeBean);
    }

	@Override
	public void removeEmployee(String empCode) {
        hrApplicationService.removeEmployee(empCode);
	}

	@Override
	public ArrayList<DepartmentBean> findDeptList() {
        return hrApplicationService.findDeptList();
	}

	@Override
	public ArrayList<DepartmentBean> findDetailDeptList(String workplaceCode) {
        return hrApplicationService.findDetailDeptList(workplaceCode);
	}

}
