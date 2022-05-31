package net.plang.HoWooAccount.system.authority.to;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AuthorityMenuPKBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String authorityCode;
    private String menuCode;

    public boolean equals(Object other) {
        return true;
    }

    public int hashCode() {
        return 0;
    }
}
