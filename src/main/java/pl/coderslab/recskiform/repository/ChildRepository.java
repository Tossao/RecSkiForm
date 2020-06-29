package pl.coderslab.recskiform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.recskiform.entity.Child;
import pl.coderslab.recskiform.entity.Level;
import pl.coderslab.recskiform.entity.Style;

import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

    List<Child>findFirst5ByOrderByIdDesc();
    List<Child> findByStyle(Style style);
    List<Child> findByLevel(Level level);



}
