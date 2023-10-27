package com.campus.campus_hotel_artichaut_backend.model.entity;

import com.campus.campus_hotel_artichaut_backend.security.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String address;

    @PositiveOrZero
    private int numberOfNights;

    @OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;



    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "medias_customers",
            joinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "avatar_id", referencedColumnName = "id")})
    private Media avatar;

}
