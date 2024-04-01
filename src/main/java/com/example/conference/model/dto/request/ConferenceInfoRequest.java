package com.example.conference.model.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ConferenceInfoRequest {
    String NameConference;
    String date;
    String time;
    String city;
    String street;
    Integer houseNumber;
    Integer roomNumber;
}
