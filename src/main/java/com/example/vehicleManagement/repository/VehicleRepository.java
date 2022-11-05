package com.example.vehicleManagement.repository;

import com.example.vehicleManagement.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository <Vehicle, Integer> {

}
