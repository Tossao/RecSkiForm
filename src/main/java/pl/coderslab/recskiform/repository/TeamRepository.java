package pl.coderslab.recskiform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.recskiform.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
