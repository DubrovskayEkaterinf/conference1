package com.example.conference.model.db.entity;

import com.example.conference.model.enums.ConferenceStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "conferences")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name_conference")
    String nameConference;

    @Column(name = "date_conference")
    String dateEvent;

    @Column(name = "time_conference")
    String timeEvent;

    @Column(name = "city")
    String city;

    @Column(name = "street")
    String street;

    @Column(name = "house_number")
    Integer houseNumber;

    @Column(name = "room_number")
    Integer roomNumber;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    @Column(name = "update_at")
    LocalDateTime updateAt;

    ConferenceStatus Status;


    @ManyToOne
    @JsonBackReference(value = "participant_conferences")
    User user;

}
