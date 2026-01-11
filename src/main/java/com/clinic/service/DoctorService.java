package com.clinic.service;
import com.clinic.model.Doctor;
import com.clinic.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // Question 10: Method to get available slots for a specific doctor
    public List<LocalDateTime> getAvailableSlots(Long doctorId, LocalDateTime afterTime) {
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        if (doctor.isPresent()) {
            return doctor.get().getAvailableTimes().stream()
                    .filter(time -> time.isAfter(afterTime))
                    .collect(Collectors.toList());
        }
        return List.of();
    }

    // Question 10: Method to validate doctor login (Simulation)
    public boolean validateLogin(String email, String password) {
        // In a real app, you would check the database and encrypted password
        return "admin@clinic.com".equals(email) && "password123".equals(password);
    }

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }
}