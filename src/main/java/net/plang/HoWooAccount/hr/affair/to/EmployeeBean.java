package net.plang.HoWooAccount.hr.affair.to;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.plang.HoWooAccount.system.base.to.BaseBean;
import net.plang.HoWooAccount.system.common.annotation.Dataset;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="EMPLOYEE")
@Dataset(name="gds_emp")
@Data
@Setter
@Getter
public class EmployeeBean extends BaseBean {

    private String BasicAddress;
    private String DetailAddress;
    private String userOrNot;
    private String deptName;
    @Id
    private String empCode;
    private String empName;
    private String companyCode;
    private String workplaceCode;//db에 WORK_PLACE_CODE로 적힌게 아니라 WORKPLACE_CODE로 컬럼명이 되어 있었다.
    private String deptCode;
    private String positionCode;
    private String positionName;
    private String socialSecurityNumber;
    private String birthDate;
    private String gender;
    private String email;
    private String phoneNumber;
    private String image;
    private String userPw;
    private String ZipCode;
    @Transient    //해당 데이터를 테이블과 매칭 시키지 않게 하는 것.-> 그냥 제외 시킴.
    private String status;
}
