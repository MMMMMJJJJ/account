package net.plang.HoWooAccount.system.authority.repository;

import net.plang.HoWooAccount.system.authority.to.AuthorityBean;
import org.springframework.data.repository.CrudRepository;

public interface AuthorityRepository extends CrudRepository<AuthorityBean,String> {
}
