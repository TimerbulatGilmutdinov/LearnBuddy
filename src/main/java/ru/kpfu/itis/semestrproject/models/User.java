package ru.kpfu.itis.semestrproject.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String passwordHash;
    private String birthdate;
    private String gender;
    private String country;
    private String city;
    private boolean isAdmin;

    public User(String name, String surname, String email, String passwordHash, String birthdate, String gender, String country, String city) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.passwordHash = passwordHash;
        this.birthdate = birthdate;
        this.gender = gender;
        this.country = country;
        this.city = city;
        this.isAdmin = false;
    }
}
