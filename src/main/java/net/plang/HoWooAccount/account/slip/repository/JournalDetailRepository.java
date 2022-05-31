package net.plang.HoWooAccount.account.slip.repository;

import net.plang.HoWooAccount.account.slip.entity.JournalDetailEntity;
import org.springframework.data.repository.CrudRepository;

public interface JournalDetailRepository extends CrudRepository<JournalDetailEntity, String> {
    public boolean existsByJournalNoContaining(String code); // 해당 code 즉, slipNo를 포함하는 저널 존재 여부 확인
    //존재여부 확인 where JournalNo like %?!%

    public void deleteByJournalNoContaining(String code);
    //delete from JorunalDetail where journalNo like %?1%

}