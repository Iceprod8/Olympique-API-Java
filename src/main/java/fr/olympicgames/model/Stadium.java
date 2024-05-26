package fr.olympicgames.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "stadiums")
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private int capacity;

    @OneToMany(mappedBy = "stadium", cascade = CascadeType.ALL)
    private List<Event> events;
}
