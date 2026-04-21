package com.ra.ptit_cntt2_it210_ss12_btth;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientRepository {
    private List<Patient> patients = new ArrayList<>();

    public List<Patient> findAll() { return patients; }
    public void save(Patient p) { patients.add(p); }
}