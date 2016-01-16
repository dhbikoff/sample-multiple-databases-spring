package sample.dbtwo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.dbtwo.models.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {
}
