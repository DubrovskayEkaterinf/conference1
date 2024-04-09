package com.example.conference.exceptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessege {
    private String messege;

    public ErrorMessege(String messege) {
        this.messege = messege;
    }
}
