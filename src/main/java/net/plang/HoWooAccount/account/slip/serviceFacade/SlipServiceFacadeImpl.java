package net.plang.HoWooAccount.account.slip.serviceFacade;

import net.plang.HoWooAccount.account.slip.applicationService.JournalApplicationService;
import net.plang.HoWooAccount.account.slip.applicationService.JournalDetailApplicationService;
import net.plang.HoWooAccount.account.slip.applicationService.SlipApplicationService;
import net.plang.HoWooAccount.account.slip.entity.JournalDetailEntity;
import net.plang.HoWooAccount.account.slip.entity.JournalEntity;
import net.plang.HoWooAccount.account.slip.entity.SlipEntity;
import net.plang.HoWooAccount.account.slip.to.JournalBean;
import net.plang.HoWooAccount.account.slip.to.JournalDetailBean;
import net.plang.HoWooAccount.account.slip.to.SlipBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class SlipServiceFacadeImpl implements SlipServiceFacade {

    @Autowired
    private JournalDetailApplicationService journalDetailApplicationService;
    @Autowired
    private JournalApplicationService journalApplicationService;
    @Autowired
    private SlipApplicationService slipApplicationService;

    @Override
    public String editJournalDetail(JournalDetailBean journalDetailBean) {
        return journalDetailApplicationService.editJournalDetail(journalDetailBean);
    }

    @Override
    public ArrayList<JournalDetailBean> getJournalDetailList(String journalNo) {
        return journalDetailApplicationService.getJournalDetailList(journalNo);
    }
    
    @Override
    public ArrayList<JournalBean> getRangedJournalList(HashMap<String, String> param) {
        return journalApplicationService.getRangedJournalList(param);
    }

    @Override
    public ArrayList<JournalBean> findSingleJournalList(String slipNo) {
        return journalApplicationService.findSingleJournalList(slipNo);
    }
    
    @Override
    public void deleteJournal(String journalNo) {
        journalApplicationService.deleteJournal(journalNo);
    }

    @Override
    public void addSlip(SlipEntity slipObj, ArrayList<JournalEntity> journal,ArrayList<JournalDetailEntity> journalDetail) {
        slipApplicationService.addSlip(slipObj, journal,journalDetail);
    }

    
    @Override
    public void deleteSlip(String slipNo) {
        slipApplicationService.deleteSlip(slipNo);
    }

    @Override
    public String updateSlip(SlipBean slipBean, ArrayList<JournalBean> journalBeans) {
        return slipApplicationService.updateSlip(slipBean, journalBeans);
    }

    @Override
    public void approveSlip(ArrayList<SlipEntity> slipBeans) {
            slipApplicationService.approveSlip(slipBeans);
    }

    @Override
    public ArrayList<SlipBean> findSlipDataList(String slipDate) {
        return slipApplicationService.findSlipDataList(slipDate);
    }

    @Override
    public ArrayList<SlipBean> findRangedSlipList(HashMap<String, String> param) {
        //윗기수처럼 굳이 String3개로 넘기기 보다 그냥 hashMap으로 담음.
        return slipApplicationService.findRangedSlipList(param);
    }

    @Override
    public ArrayList<SlipEntity> findDisApprovalSlipList(String from, String to) {
        return slipApplicationService.findDisApprovalSlipList(from,to);
    }

	@Override
	public HashMap<String,Object> getAccountingSettlementStatus(HashMap<String, Object> param) {
        return slipApplicationService.getAccountingSettlementStatus(param);
	}

	@Override
    public ArrayList<JournalBean> findRangedDetailJournalList(HashMap<String,Object> param){
        return journalApplicationService.findRangedDetailJournalList(param);
    };
}
