# Smart Clinic Management System - Database Schema (MySQL)

### 1. Doctors Table
Stores information about the medical staff.
- `id`: **BIGINT** (Primary Key, Auto-increment)
- `name`: **VARCHAR(255)** (Not Null)
- `specialty`: **VARCHAR(100)** (Not Null)

### 2. Patients Table
Stores information about registered patients.
- `id`: **BIGINT** (Primary Key, Auto-increment)
- `name`: **VARCHAR(255)** (Not Null)
- `email`: **VARCHAR(100)** (Unique, Not Null)
- `phone_number`: **VARCHAR(20)**

### 3. Appointments Table
Maps doctors to patients with specific timings.
- `id`: **BIGINT** (Primary Key, Auto-increment)
- `appointment_time`: **DATETIME** (Not Null)
- `reason`: **VARCHAR(255)**
- `status`: **VARCHAR(50)** (e.g., 'Confirmed', 'Pending')
- `doctor_id`: **BIGINT** (**Foreign Key** referencing `Doctors.id`)
- `patient_id`: **BIGINT** (**Foreign Key** referencing `Patients.id`)

## Relationships
- **One-to-Many**: One Doctor can have multiple Appointments (`Doctor` -> `Appointments`).
- **One-to-Many**: One Patient can book multiple Appointments (`Patient` -> `Appointments`).
