package com.kt3.omos.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Account extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String username;
    private String password;
    private boolean active;
    @OneToOne
    private Profile profile;
    @OneToMany(mappedBy = "account")
    private Set<Address> addresses;
    @ManyToMany
    @JoinTable(
            name = "Account_Role",
            joinColumns = { @JoinColumn(name = "account_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private Set<Role> roles;
}
