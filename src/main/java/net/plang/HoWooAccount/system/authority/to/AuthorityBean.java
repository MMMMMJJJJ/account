package net.plang.HoWooAccount.system.authority.to;

import lombok.Data;
import net.plang.HoWooAccount.system.common.annotation.Dataset;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="AUTHORITY")
@Dataset(name="gds_authority")
@Data
public class AuthorityBean {
    @Id
    private String authorityCode;
    private String authorityName;
    @Transient
    private String status;
}
