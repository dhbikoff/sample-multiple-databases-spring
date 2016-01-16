package sample.dbtwo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.dbtwo.models.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
}
