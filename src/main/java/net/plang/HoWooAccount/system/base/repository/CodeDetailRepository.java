package net.plang.HoWooAccount.system.base.repository;

import net.plang.HoWooAccount.system.base.to.CodeDetailBean;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CodeDetailRepository extends CrudRepository<CodeDetailBean, String> {
    public ArrayList<CodeDetailBean> findByDivisionCodeNo(String divisionCodeNo);
    //where DIVISION_CODE_NO=?; 구분코드번호
}