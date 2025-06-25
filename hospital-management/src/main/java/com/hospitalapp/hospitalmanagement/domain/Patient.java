package com.hospitalapp.hospitalmanagement.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-generate the primary key
    private Integer patientId;

    @Column(nullable = false)
    private String name;
    private String gender;
    private int age;
    private String contactNumber;
    private String address;

    //data output mapping
    //@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY) // infrequently data accessing, need to call
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL) // frequently data accessing
    //we are taking many appointments so it should be a List
    private List<Appointment> appointment = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

}
