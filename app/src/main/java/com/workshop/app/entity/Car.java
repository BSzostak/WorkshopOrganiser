package com.workshop.app.entity;

import com.workshop.app.car.FuelType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    @Size(min = 17, max = 17)
    private String vin;
    @Column(unique = true, nullable = false)
    private String registrationNumber;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;
    @Min(value = 1950)
    private Integer productionYear;
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Client owner;

}
