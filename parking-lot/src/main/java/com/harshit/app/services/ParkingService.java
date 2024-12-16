package com.harshit.app.services;

import com.harshit.app.database.DataStore;
import com.harshit.app.entities.Floor;
import com.harshit.app.entities.ParkingLot;
import com.harshit.app.entities.ParkingSlotStatus;
import com.harshit.app.entities.Slot;
import com.harshit.app.entities.Ticket;
import com.harshit.app.entities.Vehicle;
import com.harshit.app.entities.VehicleType;

public class ParkingService {

    public static Ticket ParkVehicle(ParkingLot parkingLot, Vehicle vehicle) {
        Integer floorNumber = -1, slotNumber = -1;
        Slot slot = null;
        for (Floor floor : parkingLot.getFloors()) {
            slot = floor.findAvailableSlot(vehicle.getType());
            if (slot != null) {
                floorNumber = floor.getId();
                slotNumber = slot.getId();
                break;
            }
        }
        if (floorNumber.equals(-1)) {
            System.out.println("PARKING IS FULL........");
            return null;
        }
        String ticketId = parkingLot.getId() + "_" + floorNumber + "_" + slotNumber;
        slot.setStatus(ParkingSlotStatus.OCCUPIED);
        Ticket ticket = new Ticket(ticketId, vehicle);
        slot.setTicket(ticket);
        DataStore.tickets.put(ticketId, ticket);
        System.out.println("Vehicle parked " + vehicle.getType());
        return ticket; 
    }

    public static void unparkVehicle(String ticketId){
        String[] s = ticketId.split("_");
        String parkingId = s[0];
        Integer floorId = Integer.valueOf(s[1]);
        Integer slotId = Integer.valueOf(s[2]);
        ParkingLot parkingLot = DataStore.parkingLots.get(parkingId);
        for (Floor floor : parkingLot.getFloors()) {
            if (!floor.getId().equals(floorId)) {
                continue;
            }
            for (Slot slot : floor.getSlots()) {
                if (!slot.getId().equals(slotId)) {
                    continue;
                }
                slot.releaseSlot();
                System.out.println("Vehicle unparked");
                return;
            }
        }
    }

    public static void showFreeSlots(ParkingLot parkingLot, VehicleType vehicleType) {
        for (Floor floor : parkingLot.getFloors()) {
            for (Slot slot : floor.getSlots()) {
                if (slot.getType() == vehicleType && slot.getStatus() == ParkingSlotStatus.UNOCCUPIED) {
                    System.out.println("floor " + floor.getId() + " and slot " + slot.getId() + " is available");
                }
            }
        }
    }

    public static void showFreeSlotsCount(ParkingLot parkingLot, VehicleType vehicleType) {
        Integer count = 0;
        for (Floor floor : parkingLot.getFloors()) {
            for (Slot slot : floor.getSlots()) {
                if (slot.getType() == vehicleType && slot.getStatus() == ParkingSlotStatus.UNOCCUPIED) {
                    count++;
                }
            }
        }
        System.out.println(count + " slots are available for vehicletype " + vehicleType);
    }

    public static void showOccupiedSlots(ParkingLot parkingLot, VehicleType vehicleType) {
        for (Floor floor : parkingLot.getFloors()) {
            for (Slot slot : floor.getSlots()) {
                if (slot.getType() == vehicleType && slot.getStatus() == ParkingSlotStatus.OCCUPIED) {
                    System.out.println("floor " + floor.getId() + " and slot " + slot.getId() + " is occupied");
                }
            }
        }
    }
}
