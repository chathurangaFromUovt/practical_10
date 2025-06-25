package com.hospitalapp.hospitalmanagement.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;

    private String name;
    private String specialization;
    private String contactNumber;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;

    //data output mapping
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    //we are taking many appointments so it should be a List
    private List<Appointment> appointment = new ArrayList<>();

}
