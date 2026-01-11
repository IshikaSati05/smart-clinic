package com.clinic.controller;
import com.clinic.service.DoctorService;
import com.clinic.model.Doctor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // Question 5: GET endpoint for doctor availability
    @GetMapping("/{id}/availability")
    public ResponseEntity<?> getAvailability(
            @PathVariable Long id, 
            @RequestHeader("Authorization") String token) {
        
        // Validate token (Basic simulation for the criteria)
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body("Unauthorized: Invalid Token");
        }

        // Return structured response using ResponseEntity
        return ResponseEntity.ok(doctorService.getAvailableSlots(id, LocalDateTime.now()));
    }

    // Question 24: GET all doctors
    @GetMapping
    public ResponseEntity<?> getAllDoctors() {
        return ResponseEntity.ok(doctorService.findAll());
    }
}