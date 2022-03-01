package ru.rtech.education.model;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    @NotNull
    private String login;

    @NotNull
    private String firstName;

    @NonNull
    private String lastName;

}
