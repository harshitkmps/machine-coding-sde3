package com.harshit.app.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter

public class ParkingLot {
    String id;
    List<Floor> floors;

    public ParkingLot(String id, Integer numberOfFloors, Integer numberOfSlotsPerFloor) {
        this.id = id;
        this.floors = new ArrayList<>();
        for (int i = 0; i < numberOfFloors; i++) {
            floors.add(new Floor(i + 1, numberOfSlotsPerFloor));
        }
    }
}
