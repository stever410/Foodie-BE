package com.ducnt.foodie.model;

import com.ducnt.foodie.common.UserRole;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "Role")
@Entity(name= "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private UserRole name;

}
