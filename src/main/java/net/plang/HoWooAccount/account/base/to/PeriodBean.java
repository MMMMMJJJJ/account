package net.plang.HoWooAccount.account.base.to;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.plang.HoWooAccount.system.base.to.BaseBean;
import net.plang.HoWooAccount.system.common.annotation.Dataset;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="PERIOD")
@Dataset(name="gds_period")
@Setter
@Getter
public class PeriodBean {
	@Id
	private String accountPeriodNo;
	private String workplaceCode;
	private String periodStartDate;
	private String periodEndDate;
	
}
