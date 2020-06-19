package pl.coderslab.recskiform.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "childs")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private int age;

    @ManyToMany
    @JoinTable(name = "child_groups", joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "groups_id"))
    private List<Group> groups = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "child_skills", joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "skills_id"))
    private List<Skill> skills = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "child_levels", joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "levels_id"))
    private List<Level> levels = new ArrayList<>();

    private String childDescription;








}
