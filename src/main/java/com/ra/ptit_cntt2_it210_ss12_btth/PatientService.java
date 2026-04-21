package com.ra.ptit_cntt2_it210_ss12_btth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public void addPatient(Patient p) {
        patientRepository.save(p);
    }
}