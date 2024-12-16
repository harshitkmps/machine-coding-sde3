package com.harshit.app.services;
import com.harshit.app.database.DataStore;
import com.harshit.app.entities.ParkingLot;

public class AdminService {
    public static ParkingLot createParkingLot(String id, Integer nFloors, Integer nSlots){
        ParkingLot parkingLot = new ParkingLot(id, nFloors, nSlots);
        DataStore.parkingLots.put(id, parkingLot);
        System.out.println("Parking lot created");
        return parkingLot;
    }
}
