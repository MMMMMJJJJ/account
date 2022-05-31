package net.plang.HoWooAccount.company.to;

import lombok.Getter;
import lombok.Setter;
import net.plang.HoWooAccount.system.base.to.BaseBean;
@Setter
@Getter
public class WorkplaceBean extends BaseBean{

	private String workplaceCode;
    private String companyCode;
    private String workplaceName;
    private String businessLicense;
    private String corporationLicence;
    private String workplaceCeoName;
    private String businessConditions;
    private String businessItems;
    private String workplaceTelNumber;
    private String workplaceFaxNumber;
    private String workplaceBasicAddress;
    private String approvalStatus; 

}
