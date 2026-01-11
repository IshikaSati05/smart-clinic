package com.clinic.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    /**
     * POST endpoint to save a prescription.
     * Criteria: Validates token and request body, returns structured response.
     */
    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> savePrescription(
            @RequestHeader("Authorization") String token, 
            @RequestBody Map<String, String> prescriptionData) {

        Map<String, String> response = new HashMap<>();

        // 1. Basic Token Validation (Simulation)
        if (token == null || !token.startsWith("Bearer ")) {
            response.put("status", "error");
            response.put("message", "Unauthorized access: Invalid or missing token");
            return ResponseEntity.status(401).body(response);
        }

        // 2. Body Validation (Check if medicine details exist)
        if (!prescriptionData.containsKey("medicineName") || !prescriptionData.containsKey("patientId")) {
            response.put("status", "error");
            response.put("message", "Validation failed: Medicine name and Patient ID are required");
            return ResponseEntity.badRequest().body(response);
        }

        // 3. Success Response
        response.put("status", "success");
        response.put("message", "Prescription saved successfully for Patient ID: " + prescriptionData.get("patientId"));
        return ResponseEntity.ok(response);
    }
}