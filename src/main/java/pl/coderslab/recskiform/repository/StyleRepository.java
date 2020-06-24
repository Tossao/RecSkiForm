package pl.coderslab.recskiform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.recskiform.entity.Style;

public interface StyleRepository extends JpaRepository<Style, Long> {
}
