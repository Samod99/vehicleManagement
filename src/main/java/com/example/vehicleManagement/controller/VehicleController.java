package com.example.vehicleManagement.controller;

import com.example.vehicleManagement.exception.ResourceNotFoundException;
import com.example.vehicleManagement.model.Vehicle;
import com.example.vehicleManagement.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    //create vehicle rest api
    @PostMapping("/vehicles")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {

        return vehicleRepository.save(vehicle);
    }

    //get all vehicles
    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {

        return vehicleRepository.findAll();
    }

    //get vehicle by id rest api
    @GetMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Integer id) {

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not exist with id :" + id));
        return ResponseEntity.ok(vehicle);
    }

    //update vehicle rest api
    @PutMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Integer id, @RequestBody Vehicle vehicleDetails) {

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not exist with id :" +id));

        vehicle.setVehicleNumber(vehicleDetails.getVehicleNumber());
        vehicle.setVehicleType(vehicleDetails.getVehicleType());
        vehicle.setFuelType(vehicleDetails.getFuelType());
        vehicle.setDriverName(vehicleDetails.getDriverName());

        Vehicle updatedVehicle = vehicleRepository.save(vehicle);
        return ResponseEntity.ok(updatedVehicle);
    }

    //delete vehicle rest api
    @DeleteMapping("/vehicles/{id}")
    public  ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer id) {

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not exist with id :" +id));

        vehicleRepository.delete(vehicle);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
