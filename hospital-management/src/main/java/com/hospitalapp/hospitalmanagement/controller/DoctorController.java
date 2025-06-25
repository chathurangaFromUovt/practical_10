package com.hospitalapp.hospitalmanagement.controller;

import com.hospitalapp.hospitalmanagement.domain.Doctor;
import com.hospitalapp.hospitalmanagement.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000")
public class DoctorController {

    private final DoctorRepository doctorRepo;

    public DoctorController(DoctorRepository doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @PostMapping("/doctor")
//    @Transactional
//    public String saveDoctor(){
//
//        Doctor doctor = new Doctor();
//        doctor.setName("Dr. Kamal");
//        doctor.setContactNumber("0123456789");
//        doctor.setSpecialization("Heart");
//
//        entityManager.persist(doctor);
//        return "Doctor saved";
//    }
//
//    @GetMapping("/doctor")
//    public List<Doctor> getDoctor(){
//
//        return entityManager.createQuery("SELECT d FROM Doctor d", Doctor.class).getResultList();
//
//    }

    @GetMapping("/doctor")
    public List<Doctor> getDoctor(){

        return doctorRepo.findAll();

    }

    @PostMapping("/doctor")
    @Transactional
    public Doctor saveDoctor(@RequestBody Doctor doctor){

//        Doctor doctor = new Doctor();
//        doctor.setName("Dr. Kamal");
//        doctor.setContactNumber("0123456789");
//        doctor.setSpecialization("Heart");

        return doctorRepo.save(doctor);
    }
}
