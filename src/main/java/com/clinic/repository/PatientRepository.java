package com.clinic.repository;
import com.clinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    
    // Question 8: Method to find a patient by their email
    Optional<Patient> findByEmail(String email);

    // Question 8: Method to find a patient by their phone number
    Optional<Patient> findByPhoneNumber(String phoneNumber);
}