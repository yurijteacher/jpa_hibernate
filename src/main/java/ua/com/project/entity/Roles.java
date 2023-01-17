package ua.com.project.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "fix_roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<Users> usersSet;


}
