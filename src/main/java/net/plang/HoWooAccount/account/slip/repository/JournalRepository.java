package net.plang.HoWooAccount.account.slip.repository;

import net.plang.HoWooAccount.account.slip.entity.JournalEntity;
import org.springframework.data.repository.CrudRepository;

public interface JournalRepository extends CrudRepository<JournalEntity, String> {
    public boolean existsBySlipNo(String slipNo); // 주어진 아이디로 식별된 엔티티 존재 여부 반환. 분개가 없을 가능성이 있다.
    //존재여부 확인  where SlipNo like %?%

    public void deleteBySlipNo(String slipNo);
    //delete from Journal where SlipNo like %?%

}