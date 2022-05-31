package net.plang.HoWooAccount.system.authority.to;

import lombok.Data;
import net.plang.HoWooAccount.system.common.annotation.Dataset;

import javax.persistence.*;

@Entity
@IdClass(AuthorityMenuPKBean.class) //pk가 2개이상일경우 IdClass를 선언 해야 한다.
@Table(name="AUTHORITY_MENU")
@Dataset(name="gds_authority_menu")
@Data
public class AuthorityMenuBean {
    @Id
    private String authorityCode;
    private String authorityName;
    @Id
    private String menuCode;
    private String menuName;
    @Transient
    private String status;
}
