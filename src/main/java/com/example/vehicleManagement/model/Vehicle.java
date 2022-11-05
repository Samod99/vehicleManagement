package com.example.vehicleManagement.model;

import javax.persistence.*;

@Entity
@Table(name = "Vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Vehicle Number")
    private String vehicleNumber;

    @Column(name = "Vehicle Type")
    private String vehicleType;

    @Column(name = "Fuel Type")
    private String fuelType;

    @Column(name = "Driver's Name")
    private String driverName;

    public Vehicle() {

    }

    public Vehicle(String vehicleNumber, String vehicleType, String fuelType, String driverName) {

        super();
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
        this.driverName = driverName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}
