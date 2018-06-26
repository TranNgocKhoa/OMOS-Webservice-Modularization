package com.kt3.omos.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Privilege extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "Privilege_Role",
            joinColumns = { @JoinColumn(name = "privilege_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private Set<Role> roles;

}
