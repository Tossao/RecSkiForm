package pl.coderslab.recskiform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.recskiform.entity.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long> {
}
