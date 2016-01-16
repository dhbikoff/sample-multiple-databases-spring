package sample.dbtwo.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.Application;
import sample.dbtwo.models.Account;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepo;

    @Test
    public void accountRepoTest() throws Exception {
        accountRepo.deleteAll();
        Account account = accountRepo.save(new Account());

        Account fetchedAccount = accountRepo.findOne(account.getId());

        assertThat(fetchedAccount).isEqualTo(account);
    }
}