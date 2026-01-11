package com.clinic.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String specialty;

    @ElementCollection
    @CollectionTable(name = "doctor_availability", joinColumns = @JoinColumn(name = "doctor_id"))
    @Column(name = "available_slot")
    private List<LocalDateTime> availableTimes;

    // Standard Default Constructor (Required by JPA)
    public Doctor() {}

    // Constructor with fields
    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    // Getters and Setters
    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public String getSpecialty() { 
        return specialty; 
    }

    public void setSpecialty(String specialty) { 
        this.specialty = specialty; 
    }

    public List<LocalDateTime> getAvailableTimes() { 
        return availableTimes; 
    }

    public void setAvailableTimes(List<LocalDateTime> availableTimes) { 
        this.availableTimes = availableTimes; 
    }
}