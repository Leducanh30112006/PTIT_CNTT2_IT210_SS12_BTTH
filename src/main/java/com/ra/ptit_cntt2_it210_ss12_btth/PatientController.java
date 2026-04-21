package com.ra.ptit_cntt2_it210_ss12_btth;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "patient-list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient-add";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("patient") Patient patient,
                       BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "patient-add";
        }
        patientService.addPatient(patient);

        return "redirect:/patients";
    }
}