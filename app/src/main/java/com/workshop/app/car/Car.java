package com.workshop.app.car;

import com.workshop.app.client.Client;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @Size(min = 17, max = 17)
    private String vin;
    @Column(unique = true)
    private String registrationNumber;
    private String brand;
    private String model;
    @Min(value = 1950)
    @Max(value = 2026)
    private int productionYear;
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Client owner;

}
