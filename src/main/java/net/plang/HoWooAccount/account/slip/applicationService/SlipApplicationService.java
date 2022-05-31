package net.plang.HoWooAccount.account.slip.applicationService;

import net.plang.HoWooAccount.account.slip.entity.JournalDetailEntity;
import net.plang.HoWooAccount.account.slip.entity.JournalEntity;
import net.plang.HoWooAccount.account.slip.entity.SlipEntity;
import net.plang.HoWooAccount.account.slip.to.JournalBean;
import net.plang.HoWooAccount.account.slip.to.SlipBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public interface SlipApplicationService {

    ArrayList<SlipBean> findSlipDataList(String slipDate);

    ArrayList<SlipBean> findRangedSlipList(HashMap<String, String> param);

    ArrayList<SlipEntity> findDisApprovalSlipList(String from, String to);

    void addSlip(SlipEntity slipObj, ArrayList<JournalEntity> journal, ArrayList<JournalDetailEntity> journalDetail);

    void deleteSlip(String slipNo);

    String updateSlip(SlipBean slipBean, ArrayList<JournalBean> journalBeans);

    void approveSlip(ArrayList<SlipEntity> slipBeans);

    HashMap<String,Object> getAccountingSettlementStatus(HashMap<String, Object> param);

}
