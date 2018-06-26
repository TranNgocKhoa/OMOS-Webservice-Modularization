package com.kt3.omos.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<Privilege> privileges;
    @ManyToMany(mappedBy = "roles")
    private Set<Account> accounts;
}
