package pl.coderslab.recskiform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.recskiform.entity.Child;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {
}
