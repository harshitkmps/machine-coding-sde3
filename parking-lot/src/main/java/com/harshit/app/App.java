package com.harshit.app;

import com.harshit.app.entities.ParkingLot;
import com.harshit.app.entities.Ticket;
import com.harshit.app.entities.Vehicle;
import com.harshit.app.entities.VehicleType;
import com.harshit.app.services.AdminService;
import com.harshit.app.services.ParkingService;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ParkingLot p1 = AdminService.createParkingLot("ABC123", 2, 5);
        ParkingService.showFreeSlots(p1, VehicleType.TRUCK);
        ParkingService.showFreeSlots(p1, VehicleType.BIKE);
        ParkingService.showFreeSlots(p1, VehicleType.CAR);
        Vehicle c1 = new Vehicle("RJ01AB0001", "BLUE", VehicleType.CAR);
        Vehicle c2 = new Vehicle("RJ01AB0002", "BLACK", VehicleType.CAR);
        Vehicle c3 = new Vehicle("RJ01AB0003", "RED", VehicleType.CAR);
        Vehicle c4 = new Vehicle("RJ01AB0004", "GREEN", VehicleType.CAR);
        
        Vehicle t1 = new Vehicle("RJ01AB0001", "BLUE", VehicleType.TRUCK);
        Vehicle t2 = new Vehicle("RJ01AB0002", "BLACK", VehicleType.TRUCK);
        Vehicle t3 = new Vehicle("RJ01AB0003", "RED", VehicleType.TRUCK);
        Vehicle t4 = new Vehicle("RJ01AB0004", "GREEN", VehicleType.TRUCK);

        Ticket ticket1 = ParkingService.ParkVehicle(p1, c1);
        Ticket ticket2 = ParkingService.ParkVehicle(p1, t1);
        Ticket ticket3 = ParkingService.ParkVehicle(p1, t2);
        Ticket ticket4 = ParkingService.ParkVehicle(p1, t3);
        Ticket ticket5 = ParkingService.ParkVehicle(p1, t4);
        ParkingService.showFreeSlotsCount(p1, VehicleType.BIKE);
        ParkingService.showFreeSlotsCount(p1, VehicleType.CAR);
        ParkingService.showFreeSlotsCount(p1, VehicleType.TRUCK);
        ParkingService.unparkVehicle(ticket1.getId());
        ParkingService.showFreeSlotsCount(p1, VehicleType.CAR);
    }
}
