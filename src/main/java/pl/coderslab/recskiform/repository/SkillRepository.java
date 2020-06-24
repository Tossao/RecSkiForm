package pl.coderslab.recskiform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.recskiform.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
