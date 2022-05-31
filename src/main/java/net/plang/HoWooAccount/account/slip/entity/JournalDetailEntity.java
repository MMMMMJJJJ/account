package net.plang.HoWooAccount.account.slip.entity;

import lombok.Data;
import net.plang.HoWooAccount.system.common.annotation.Dataset;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="DETAIL_NO", sequenceName="JOURNAL_DETAIL_NO_SEQUENCE", allocationSize=1)
@Table(name="JOURNAL_DETAIL")
@Dataset(name="gds_journal_detail")
@Data
public class JournalDetailEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="DETAIL_NO")
    //뒤에 적힌 generator는 위쪽에 적은 sequenceGenerator에 적어둔 시퀸스 값을 적는다는 뜻을 의미. @Id와는 같이 사용 되어야 한다.
    private int journalDetailNo;
    private String accountControlCode;
    private String description;
    private String journalNo;

    @Transient // 테이블의 칼럼과 매핑하지 않는다(JPA)
    private String count;

    @Transient
    private String status;

}
