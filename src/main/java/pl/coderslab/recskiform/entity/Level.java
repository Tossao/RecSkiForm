package pl.coderslab.recskiform.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "level")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String levelColor;

    private String levelDescription;

    @ManyToMany(mappedBy = "levels")
    private List<Child> childLevels = new ArrayList<>();

}
