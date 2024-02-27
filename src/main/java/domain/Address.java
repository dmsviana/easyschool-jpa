package domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;


@Embeddable
@Data
public class Address {

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String country;

    @Column
    private String referencePoint;



}
