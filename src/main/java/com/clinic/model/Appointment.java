package com.clinic.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // This connects to the Doctor class. 
    // If Doctor.java is in the same folder with the same package name, 
    // the "cannot be resolved" error will disappear.
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private LocalDateTime appointmentTime;

    // Default Constructor
    public Appointment() {}

    // Constructor for booking
    public Appointment(Doctor doctor, Patient patient, LocalDateTime appointmentTime) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentTime = appointmentTime;
    }

    // Getters and Setters
    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }

    public Doctor getDoctor() { 
        return doctor; 
    }

    public void setDoctor(Doctor doctor) { 
        this.doctor = doctor; 
    }

    public Patient getPatient() { 
        return patient; 
    }

    public void setPatient(Patient patient) { 
        this.patient = patient; 
    }

    public LocalDateTime getAppointmentTime() { 
        return appointmentTime; 
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) { 
        this.appointmentTime = appointmentTime; 
    }
}