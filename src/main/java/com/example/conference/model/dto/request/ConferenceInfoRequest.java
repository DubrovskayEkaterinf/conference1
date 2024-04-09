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
    String nameConference;
    String dateEvent;
    String timeEvent;
    String city;
    String street;
    Integer houseNumber;
    Integer roomNumber;
}
