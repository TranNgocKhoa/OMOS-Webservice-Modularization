package com.kt3.omos.domain;

import javax.persistence.*;

@Entity
public class Address extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String ward;
    private String district;
    private String city;
    private int wardNumber;
    private int districtNumber;
    private int cityNumber;
    private boolean defaultAddress;
    private boolean active;
    @ManyToOne
    private Account account;

}
