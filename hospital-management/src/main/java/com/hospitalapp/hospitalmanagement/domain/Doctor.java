package com.hospitalapp.hospitalmanagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Doctor {

    @Id
    private int id;
    @Column(nullable = false)
    private String name;
    private String contact_number;
    private String specialization;
    private String department;

}
