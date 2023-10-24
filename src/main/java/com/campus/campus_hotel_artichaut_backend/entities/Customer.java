package com.campus.campus_hotel_artichaut_backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Entity
public class Customer {

    @Id
    private long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String password;

    @NotBlank
    private String address;

    @PositiveOrZero
    private int numberOfNights;

    @Email
    @NotNull
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "medias_customers",
            joinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "avatar_id", referencedColumnName = "id")})
    private Media avatar;

}
