package com.harshit.app.database;

import java.util.HashMap;

import com.harshit.app.entities.ParkingLot;
import com.harshit.app.entities.Ticket;

public class DataStore {
    public static HashMap<String, Ticket> tickets = new HashMap<>();
    public static HashMap<String, ParkingLot> parkingLots = new HashMap<>();
}
