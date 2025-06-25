package com.hospitalapp.hospitalmanagement.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;

    private String roomNumber;
    private String type;
    private String status;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Patient> patients = new ArrayList<>();

}
