package com.hospitalapp.hospitalmanagement.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;

    private LocalDate date;
    private LocalTime time;
    private String notes;

    //@OneToOne
    //auto creates doctor_id
    //private Doctor doctor;

    //@OneToOne
    //auto creates patient_id
    //private Patient patient;

    //data input mapping
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

}
