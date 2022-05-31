package net.plang.HoWooAccount.system.base.to;

import lombok.Getter;
import net.plang.HoWooAccount.system.common.annotation.Dataset;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
@Dataset(name="gds_customer")
@Getter
public class CustomerBean {

    @Id
    private String customerCode;
    private String workplaceCode;
    private String customerName;
    private String customerType;
    private String customerCeo;
    private String businessLicenseNumber;
    private String socialSecurityNumber;
    private String customerBusinessConditions;
    private String customerBusinessItems;
    private String customerZipCode;
    private String customerBasicAddress;
    private String customerDetailAddress;
    private String customerTelNumber;
    private String customerFaxNumber;
    private String customerNote;
    private String accountNumber;
    private String cardNumber;
    private String cardType;
    private String cardMemberName;
    private String cardOpenPlace;
    private String financialInstituteCode;
    private String financialInstituteName;
}
