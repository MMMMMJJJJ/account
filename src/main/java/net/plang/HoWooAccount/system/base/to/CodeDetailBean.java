package net.plang.HoWooAccount.system.base.to;

import lombok.Data;
import net.plang.HoWooAccount.system.common.annotation.Dataset;

import javax.persistence.*;

@Entity
@Table(name="CODE_DETAIL")
@IdClass(CodeDetailPKBean.class)
@Dataset(name="gds_codeDetail")
@Data
public class CodeDetailBean {
    @Id
    private String divisionCodeNo;
    @Id
    private String detailCode;
    @Column(nullable = false)
    private String detailCodeName;
    private String codeUseCheck;
    private String description;

    @Transient
    private String status;
}
