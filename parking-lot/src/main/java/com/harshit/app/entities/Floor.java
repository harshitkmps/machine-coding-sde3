package com.harshit.app.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Floor {
    Integer id;
    Integer capacity;
    List<Slot> slots;

    private void  addSlots(Integer numberOfSlots){
        for (int i = 0; i < numberOfSlots; i++) {
            if (i < 1) {
                slots.add(new Slot(i + 1, VehicleType.TRUCK));
            } else if (i < 3) {
                slots.add(new Slot(i + 1, VehicleType.BIKE));
            } else {
                slots.add(new Slot(i + 1, VehicleType.CAR));
            }
        }
    }

    public Floor(Integer id, Integer capacity) {
        this.id = id;
        this.capacity = capacity;
        slots = new ArrayList<>();
        this.addSlots(capacity);
    }

    public Slot findAvailableSlot(VehicleType vehicleType) {
        Slot availableSlot = null;
        for (Slot slot : slots) {
            if (slot.status == ParkingSlotStatus.OCCUPIED || slot.type != vehicleType) {
                continue;
            }
            availableSlot = slot;
            break;
        }
        return availableSlot;
    }


}
