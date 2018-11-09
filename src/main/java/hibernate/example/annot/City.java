package hibernate.example.annot;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private int id;

    @Column(name="city", length = 100, nullable = true)
    @Getter
    @Setter
    private String name;

    @Column(name = "population", nullable = false)
    @Getter
    @Setter
    private double population;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "cities")

    @Getter
    @Setter
    private List<User> users=new ArrayList<>();
}
