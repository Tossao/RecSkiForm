package pl.coderslab.recskiform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.recskiform.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
