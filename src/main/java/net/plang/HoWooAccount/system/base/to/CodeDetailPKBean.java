package net.plang.HoWooAccount.system.base.to;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CodeDetailPKBean implements Serializable {
    private static final long serialVersionUID = 1L; //데이터 직렬화
    private String divisionCodeNo;
    private String detailCode;

    public boolean equals(Object other) {
        return true;
    }

    public int hashCode() {
        return 0;
    }
}
