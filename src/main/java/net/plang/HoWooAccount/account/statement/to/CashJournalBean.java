package net.plang.HoWooAccount.account.statement.to;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CashJournalBean {
	private String monthReportingDate;
	private String reportingDate;
	private String expenseReport;
	private String customerCode;
	private String customerName;
	private int deposit;
	private int withdrawal;
	private String balance;
}
