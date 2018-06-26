package com.kt3.omos.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Profile extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int gender;
    private Date birthDay;
    private String email;
    private String phone;
    private String job;
    private String paymentAddress;
    private Date registrationDate;
    @OneToOne
    private Account account;
}
