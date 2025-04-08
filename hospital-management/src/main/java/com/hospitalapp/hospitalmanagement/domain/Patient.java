package com.hospitalapp.hospitalmanagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patient {

    @Id
    private int id;
    @Column(nullable = false)
    private String name;
    private String gender;
    private int age;
    private String contact_number;
    private String address;

}
