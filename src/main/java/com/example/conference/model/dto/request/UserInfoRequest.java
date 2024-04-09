package com.example.conference.model.dto.request;

import com.example.conference.model.enums.AcademicTitles;
import com.example.conference.model.enums.Speaker;
import com.example.conference.model.enums.Specialization;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;


import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserInfoRequest {

    @NotEmpty(message = "Email must be set")
    String email;

    String password;
    String lastName;
    String firstName;
    String middleName;
    Integer age;

    @NotEmpty(message = "PhoneNumber must be set")
    String phoneNumber;

    Specialization specialization;
    AcademicTitles academicTitles;
    Speaker speaker;


}
