package com.example.msusers.domain;

import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class User {
    private String id;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
}