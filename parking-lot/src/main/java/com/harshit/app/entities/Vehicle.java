package com.harshit.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Vehicle {
    String registrationNumber;
    String color;
    VehicleType type;
}
