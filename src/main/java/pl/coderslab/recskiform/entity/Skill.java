package pl.coderslab.recskiform.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;

    private String skillDescription;

    @ManyToMany(mappedBy = "skills")
    private List<Child> childSkills = new ArrayList<>();


}
