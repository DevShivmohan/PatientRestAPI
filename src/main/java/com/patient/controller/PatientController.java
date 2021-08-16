package com.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.patient.entities.Patient;
import com.patient.service.PatientService;

@RestController
public class PatientController {
	@Autowired
	private PatientService patientService;

	// all controllers and database operations tested success

	// getting all patients
	@RequestMapping(value = "/patients", method = RequestMethod.GET)
	public ResponseEntity<List<Patient>> getPatients() {
		return patientService.getPatients();
	}

	// getting a patient
	@RequestMapping(value = "/patients/{id}", method = RequestMethod.GET)
	public ResponseEntity<Patient> getPatient(@PathVariable("id") int id) {
		return patientService.getPatient(id);
	}

	// add a patient
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Patient> addPatient() {
		return patientService.addPatient(new Patient(120, "ShivMohan", "Siddharth Nagar", "nshivmohan08@gmail.com",
				7080713024L, "Shivmohan@012"));
	}

	// delete a patient
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Patient> deletePatient(@PathVariable("id") int id) {
		return patientService.deletePatient(id);
	}

	// update record a patient
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Patient> updatePatient(@PathVariable("id") int id) {
		return patientService.updatePatient(
				new Patient(120, "Ram", "Tamil Nadu", "hgk234@gmail.com", 7080012020L, "ram@123345"), id);
	}
}
