package pl.coderslab.recskiform.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "level")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    private String levelColor;

    @NotNull
    @Size(min = 10)
    @Column(columnDefinition = "TEXT")
    private String levelDescription;

    @ManyToMany(mappedBy = "levels")
    private List<Child> childLevels = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevelColor() {
        return levelColor;
    }

    public void setLevelColor(String levelColor) {
        this.levelColor = levelColor;
    }

    public String getLevelDescription() {
        return levelDescription;
    }

    public void setLevelDescription(String levelDescription) {
        this.levelDescription = levelDescription;
    }

    public List<Child> getChildLevels() {
        return childLevels;
    }

    public void setChildLevels(List<Child> childLevels) {
        this.childLevels = childLevels;
    }

    @Override
    public String toString() {
        return "Level{" +
                "id=" + id +
                ", levelColor='" + levelColor + '\'' +
                ", levelDescription='" + levelDescription + '\'' +
                ", childLevels=" + childLevels +
                '}';
    }
}
