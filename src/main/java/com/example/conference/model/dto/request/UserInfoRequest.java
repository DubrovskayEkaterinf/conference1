package com.example.conference.model.dto.request;

import com.example.conference.model.enums.AcademicTitles;
import com.example.conference.model.enums.Specialization;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserInfoRequest {
    String email;
    String password;
    String lastName;
    String firstName;
    String middleName;
    Integer age;
    Integer phoneNumber;
    Specialization specialization;
    AcademicTitles academicTitles;
    Boolean speaker;


}
