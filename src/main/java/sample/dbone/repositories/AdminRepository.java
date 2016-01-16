package sample.dbone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.dbone.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
