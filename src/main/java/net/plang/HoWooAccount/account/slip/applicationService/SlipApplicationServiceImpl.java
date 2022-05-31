package net.plang.HoWooAccount.account.slip.applicationService;

import java.util.ArrayList;
import java.util.HashMap;

import net.plang.HoWooAccount.account.slip.entity.JournalDetailEntity;
import net.plang.HoWooAccount.account.slip.entity.JournalEntity;
import net.plang.HoWooAccount.account.slip.entity.SlipEntity;
import net.plang.HoWooAccount.account.slip.mapper.JournalDAO;
import net.plang.HoWooAccount.account.slip.mapper.JournalDetailDAO;
import net.plang.HoWooAccount.account.slip.mapper.SlipDAO;
import net.plang.HoWooAccount.account.slip.repository.JournalDetailRepository;
import net.plang.HoWooAccount.account.slip.repository.JournalRepository;
import net.plang.HoWooAccount.account.slip.repository.SlipRepository;
import net.plang.HoWooAccount.account.slip.to.JournalBean;
import net.plang.HoWooAccount.account.slip.to.JournalDetailBean;
import net.plang.HoWooAccount.account.slip.to.SlipBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SlipApplicationServiceImpl implements SlipApplicationService {

    @Autowired
    private SlipDAO slipDAO;
    @Autowired
    private JournalDAO journalDAO;
    @Autowired
    private JournalDetailDAO journalDetailDAO;
    @Autowired
    private SlipRepository slipRepository;
    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private JournalDetailRepository journalDetailRepository;

    @Override
    public ArrayList<SlipBean> findSlipDataList(String slipDate) {
        return slipDAO.selectSlipDataList(slipDate);
    }

    @Override
    public void addSlip(SlipEntity slipObj, ArrayList<JournalEntity> journalBeans, ArrayList<JournalDetailEntity> journalDetail) {

        StringBuffer slipNo = new StringBuffer();
        String slipNoDate = slipObj.getReportingDate().replace("-", "");

        // 전표번호 생성
        slipNo.append(slipNoDate); //20200118
        slipNo.append("SLIP"); // 20200118SLIP

        ArrayList<SlipEntity> slipList = slipRepository.findBySlipNoContaining(slipNoDate); // 해당 날짜에 작성한 전표
        int num = slipList.size() + 1; // 전표 수 + 1

        String code =  null;
        if (num < 10) {
            code = "0000" + num;// 00001
        }else{ code = "000" + num ;}

        slipNo.append(code.substring(code.length() - 5));   // 00001 - 5자리로 맞춰줌


        String slipNum = slipNo.toString();

        slipObj.setSlipNo(slipNum); //20200118SLIP00001
        slipRepository.save(slipObj); // slipBean 저장!

        int count = 1;

        String journalNo = journalDAO.selectJournalName(slipNum);
        // 20180401SLIP00001JOURNAL0 분개일련번호 생성. 저장된 분개가 있을 경우 +1을 한 숫자, 없을 경우 0을 반환한다.

        int jnum =  Integer.parseInt(journalNo.substring(24)); // 끝 번호를 가져옴

        for (JournalEntity journalBean : journalBeans) {
            String journalNum = slipNum +"JOURNAL"+ jnum++;

            System.out.println("journalBean : ");
            System.out.println(journalBean.getLeftDebtorPrice());
            System.out.println(journalBean.getAccountInnerCode());
            System.out.println(journalBean.getBalanceDivision());
            System.out.println(journalBean.getCustomerCode());
            System.out.println(journalBean.getJournalNo());
            System.out.println(journalBean.getRightCreditsPrice());
            System.out.println(journalBean.getSlipNo());

            journalBean.setJournalNo(journalNum);
            journalBean.setSlipNo(slipNum);


            for(JournalDetailEntity journalDetailBean: journalDetail) {
                if(Integer.parseInt(journalDetailBean.getCount()) == count) { // count는 신규 입력한 분개의 임시번호
                    journalDetailBean.setJournalNo(journalNum); // 해당 count의 분개일련번호를 세팅
                }
            }

            count += 1;

        }

        System.out.println("insert문 실행.");

        journalRepository.saveAll(journalBeans);
        journalDetailRepository.saveAll(journalDetail);
    }

    @Override
    public void deleteSlip(String slipNo) {

        slipRepository.deleteById(slipNo);

        if(journalRepository.existsBySlipNo(slipNo)) {
            journalRepository.deleteBySlipNo(slipNo);
        }

        if(journalDetailRepository.existsByJournalNoContaining(slipNo)) {
            journalDetailRepository.deleteByJournalNoContaining(slipNo);
        }
    }

    @Override
    public String updateSlip(SlipBean slipBean, ArrayList<JournalBean> journalBeans) {

        slipDAO.updateSlip(slipBean);
        System.out.println("전표업데이트");


        for (JournalBean journalBean : journalBeans) {
            journalDAO.updateJournal(journalBean);
            System.out.println("분개업데이트");
        if(journalBean.getJournalDetailList()!=null)
            for(JournalDetailBean journalDetailBean: journalBean.getJournalDetailList()) {
                journalDetailDAO.updateJournalDetail(journalDetailBean);
                System.out.println("분개상세업데이트");
            }
        }
        return slipBean.getSlipNo();
    }

    @Override
    public void approveSlip(ArrayList<SlipEntity> slipBeans) {
        for (SlipEntity slipBean : slipBeans) {
            slipRepository.save(slipBean);
        }
    }

    @Override
    public ArrayList<SlipBean> findRangedSlipList(HashMap<String, String> param) {
        System.out.println("출발");

        ArrayList<SlipBean> result = slipDAO.selectRangedSlipList(param);

        System.out.println("도착");
        return result;
    }

    @Override
    public ArrayList<SlipEntity> findDisApprovalSlipList(String fromDate, String toDate) {
        String status = "승인요청";//전표 미등록 된 것을 select 하는 것이기 때문에.
        ArrayList<SlipEntity> disApprovalSlipList = slipRepository.findBySlipStatusAndReportingDateBetweenAndApprovalDateIsNullOrderByReportingDateDescSlipNoDesc(status, fromDate, toDate);

        return disApprovalSlipList;
    }

	@Override
	public HashMap<String,Object> getAccountingSettlementStatus(HashMap<String, Object> param) {
        return slipDAO.callAccountingSettlementStatus(param);
	}
}


