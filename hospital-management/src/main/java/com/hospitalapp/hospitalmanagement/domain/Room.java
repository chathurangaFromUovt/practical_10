package com.hospitalapp.hospitalmanagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Room {

    @Id
    private int id;
    @Column(nullable = false)
    private int room_number;
    private String type;
    private String status;
}
