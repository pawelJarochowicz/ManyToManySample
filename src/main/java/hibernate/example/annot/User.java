package hibernate.example.annot;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private int id;

    @Column(name = "name", length = 100, nullable = true)
    @Getter
    @Setter
    private String name;

    @Column(name = "age", nullable = false)
    @Getter
    @Setter
    private int age;

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="user_city", joinColumns = {@JoinColumn(name="user_id")},
            inverseJoinColumns ={ @JoinColumn(name = "city_id")})

        @Getter
        @Setter
        private List<City> cities=new ArrayList<>();

}
