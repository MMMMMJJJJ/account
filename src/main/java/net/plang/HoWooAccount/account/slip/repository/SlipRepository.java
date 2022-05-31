package net.plang.HoWooAccount.account.slip.repository;

import net.plang.HoWooAccount.account.slip.entity.SlipEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface SlipRepository extends CrudRepository<SlipEntity, String> {
    public ArrayList<SlipEntity> findByReportingDateOrderBySlipNo(String reportingDate);
    //select * from SLIP where reporting_date=? Order by slipNo;

    public ArrayList<SlipEntity> findBySlipStatusAndReportingDateBetweenAndApprovalDateIsNullOrderByReportingDateDescSlipNoDesc(String status, String fromDate, String toDate);
    // from slip_status=1? and reporting_date between 2? and 3? and approval_date is null order by reporting_date, slip_no desc ;

    public ArrayList<SlipEntity> findBySlipNoContaining(String today);
    // from slip_no like %?%
}
