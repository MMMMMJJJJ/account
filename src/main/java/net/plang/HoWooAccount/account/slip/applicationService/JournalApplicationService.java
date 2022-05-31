package net.plang.HoWooAccount.account.slip.applicationService;

import java.util.ArrayList;
import java.util.HashMap;

import net.plang.HoWooAccount.account.slip.to.JournalBean;
import net.plang.HoWooAccount.account.slip.to.SlipBean;

public interface JournalApplicationService {

    public ArrayList<JournalBean> findSingleJournalList(String slipNo);

    public ArrayList<JournalBean> getRangedJournalList(HashMap<String, String> param);

    public void deleteJournal(String journalNo);

    public ArrayList<JournalBean> findRangedDetailJournalList(HashMap<String,Object> param);
}
