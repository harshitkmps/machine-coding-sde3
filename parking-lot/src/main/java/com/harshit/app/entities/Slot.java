package com.harshit.app.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Slot {
    Integer id;
    ParkingSlotStatus status;
    VehicleType type;
    Ticket ticket;

    public Slot(Integer id, VehicleType type) {
        this.id = id;
        this.type = type;
        this.status = ParkingSlotStatus.UNOCCUPIED;
    }

    public void releaseSlot(){
        this.ticket = null;
        this.status = ParkingSlotStatus.UNOCCUPIED;
    }
}
