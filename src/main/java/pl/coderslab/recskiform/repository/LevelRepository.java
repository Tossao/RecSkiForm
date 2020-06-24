package pl.coderslab.recskiform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.recskiform.entity.Level;

public interface LevelRepository extends JpaRepository<Level, Long> {
}
