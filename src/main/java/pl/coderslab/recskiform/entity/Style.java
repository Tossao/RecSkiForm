package pl.coderslab.recskiform.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "style")
public class Style {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    private String styleName;

    @NotNull
    @Size(min = 10)
    @Column(columnDefinition = "TEXT")
    private String styleDescription;

    @ManyToMany(mappedBy = "styles")
    private List<Child> childStyle = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public String getStyleDescription() {
        return styleDescription;
    }

    public void setStyleDescription(String styleDescription) {
        this.styleDescription = styleDescription;
    }

    public List<Child> getChildStyle() {
        return childStyle;
    }

    public void setChildStyle(List<Child> childStyle) {
        this.childStyle = childStyle;
    }

    @Override
    public String toString() {
        return "Style{" +
                "id=" + id +
                ", styleName='" + styleName + '\'' +
                ", styleDescription='" + styleDescription + '\'' +
                ", childStyle=" + childStyle +
                '}';
    }
}
