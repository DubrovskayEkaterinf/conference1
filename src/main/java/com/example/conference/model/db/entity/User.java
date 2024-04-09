package com.example.conference.model.db.entity;


import com.example.conference.model.enums.AcademicTitles;
import com.example.conference.model.enums.Speaker;
import com.example.conference.model.enums.Specialization;
import com.example.conference.model.enums.UserStatus;
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
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    String email;
    String password;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "middle_name")
    String middleName;

    Integer age;

    @Column(name = "phone_number")
    String phoneNumber;

    @Enumerated(EnumType.STRING)
    Specialization specialization;

    @Enumerated(EnumType.STRING)
    AcademicTitles academicTitles;

    @Enumerated(EnumType.STRING)
    Speaker speaker;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    @Column(name = "update_at")
    LocalDateTime updateAt;

    @Enumerated(EnumType.STRING)
    UserStatus Status;



    @OneToMany
    @JsonManagedReference(value = "participant_conferences")
    List<Conference> conferences;


}
