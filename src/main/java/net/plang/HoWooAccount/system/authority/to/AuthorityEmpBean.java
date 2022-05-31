package net.plang.HoWooAccount.system.authority.to;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.plang.HoWooAccount.system.base.to.BaseBean;
import net.plang.HoWooAccount.system.common.annotation.Dataset;

import javax.persistence.*;

@Entity
@IdClass(AuthorityEmpPkBean.class)
@Table(name="AUTHORITY_EMP")
@Dataset(name="gds_authority_emp")
@Data
public class AuthorityEmpBean {
    @Id
    private String empCode;
    private String empName;
    @Id
    private String authorityCode;
    private String authorityName;
    private String isAuthority;
    //private String menuCode;
    //private String menuName;
    //private String authority;
    //private String deptCode;
    @Transient
    private String status;
}
