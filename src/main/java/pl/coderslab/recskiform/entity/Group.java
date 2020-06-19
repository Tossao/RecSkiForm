package pl.coderslab.recskiform.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;

    private String groupDescription;

    @ManyToMany(mappedBy = "groups")
    private List<Child> childGroups = new ArrayList<>();

}
