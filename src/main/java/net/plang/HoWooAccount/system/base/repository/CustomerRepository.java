package net.plang.HoWooAccount.system.base.repository;

import net.plang.HoWooAccount.system.base.to.CustomerBean;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerBean,String> {
}
