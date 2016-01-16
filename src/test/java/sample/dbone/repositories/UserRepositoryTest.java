package sample.dbone.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.Application;
import sample.dbone.models.User;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepo;

    @Test
    public void userRepoTest() throws Exception {
        userRepo.deleteAll();
        User card = userRepo.save(new User("some name"));

        User fetchedCard = userRepo.findOne(card.getId());

        assertThat(fetchedCard).isEqualTo(card);
    }
}
