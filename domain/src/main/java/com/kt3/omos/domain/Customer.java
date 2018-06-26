package com.kt3.omos.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer extends Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int promotionalRewardPoint;
    private int nonPromotionalRewardPoint;
    @ManyToOne
    private MembershipType membershipType;
    @OneToMany(mappedBy = "customer")
    private Set<CustomerRewardPointLog> customerRewardPointLogs;
    @OneToMany(mappedBy = "customer")
    private Set<ProductComment> productComments;

}
