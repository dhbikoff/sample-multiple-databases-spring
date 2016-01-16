package sample.dbone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.dbone.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
