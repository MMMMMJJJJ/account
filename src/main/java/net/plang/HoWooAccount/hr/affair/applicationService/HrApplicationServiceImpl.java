package net.plang.HoWooAccount.hr.affair.applicationService;

import java.util.ArrayList;

import net.plang.HoWooAccount.hr.affair.mapper.DepartmentDAO;
import net.plang.HoWooAccount.hr.affair.mapper.EmployeeDAO;
import net.plang.HoWooAccount.hr.affair.repository.EmployeeRepository;
import net.plang.HoWooAccount.hr.affair.to.DepartmentBean;
import net.plang.HoWooAccount.hr.affair.to.EmployeeBean;
import net.plang.HoWooAccount.system.base.mapper.DetailCodeDAO;
import net.plang.HoWooAccount.system.base.to.DetailCodeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HrApplicationServiceImpl implements HrApplicationService {

    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private DetailCodeDAO detailCodeDAO;
    @Autowired
    private DepartmentDAO departmentDAO;
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public ArrayList<EmployeeBean> findEmployeeList() {
        ArrayList<EmployeeBean> empList =(ArrayList<EmployeeBean>)employeeRepository.findAll();
        return empList;
    }

    @Override
    public EmployeeBean findEmployee(String empCode) {
        return employeeDAO.selectEmployee(empCode);
    }

    @Override
    public void batchEmployeeInfo(EmployeeBean employeeBean) {
        String empCode = employeeBean.getEmpCode();
        String empName = employeeBean.getEmpName();

        employeeRepository.save(employeeBean); // 사원 등록
    }

    private void modifyEmployee(EmployeeBean employeeBean) {
        employeeDAO.updateEmployee(employeeBean);
        String empCode = employeeBean.getEmpCode();
        String empName = employeeBean.getEmpName();
        DetailCodeBean detailCodeBean = new DetailCodeBean();
        detailCodeBean.setDivisionCodeNo("HR-02");
        detailCodeBean.setDetailCode(empCode);
        detailCodeBean.setDetailCodeName(empName);
        detailCodeDAO.updateDetailCode(detailCodeBean);
    }

    public void removeEmployee(String empCode) {
        employeeDAO.deleteEmployee(empCode);
        detailCodeDAO.deleteDetailCode(empCode);
    }

    @Override
    public void registerEmployee(EmployeeBean employeeBean) {
        employeeDAO.insertEmployee(employeeBean);
        String empCode = employeeBean.getEmpCode();
        String empName = employeeBean.getEmpName();
        DetailCodeBean detailCodeBean = new DetailCodeBean();
        detailCodeBean.setDivisionCodeNo("HR-02");
        detailCodeBean.setDetailCode(empCode);
        detailCodeBean.setDetailCodeName(empName);
        detailCodeDAO.insertDetailCode(detailCodeBean);
    }

	@Override
	public ArrayList<DepartmentBean> findDeptList() {
        return departmentDAO.selectDeptList();
	}

	@Override
	public ArrayList<DepartmentBean> findDetailDeptList(String workplaceCode) {
        return departmentDAO.selectDetailDeptList(workplaceCode);
	}

    @Override
    public ArrayList<EmployeeBean> findAllEmployeeList() {
        return employeeDAO.selectAllEmployeeList();
    }

}
