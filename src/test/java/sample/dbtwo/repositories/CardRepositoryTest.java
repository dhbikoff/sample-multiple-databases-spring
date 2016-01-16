package sample.dbtwo.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.Application;
import sample.dbtwo.models.Card;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class CardRepositoryTest {

    @Autowired
    private CardRepository cardRepo;

    @Test
    public void carRepoTest() throws Exception {
        cardRepo.deleteAll();
        Card card = cardRepo.save(new Card("some card number"));

        Card fetchedCard = cardRepo.findOne(card.getId());

        assertThat(fetchedCard).isEqualTo(fetchedCard);
    }
}