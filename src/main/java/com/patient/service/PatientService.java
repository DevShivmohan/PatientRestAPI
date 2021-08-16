package com.patient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.patient.dao.PatientRepository;
import com.patient.entities.Patient;

@Component
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;

	// getting all patients
	public ResponseEntity<List<Patient>> getPatients() {
		try {
			List<Patient> patients = (List<Patient>) patientRepository.findAll();
			if (patients.size() <= 0)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			else
				return ResponseEntity.of(Optional.of(patients));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// getting single patient
	public ResponseEntity<Patient> getPatient(int id) {
		try {
			Patient patient = patientRepository.findById(id);
			if (patient == null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			else
				return ResponseEntity.of(Optional.of(patient));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// add single patient
	public ResponseEntity<Patient> addPatient(Patient patient) {
		try {
			Patient patient2 = patientRepository.save(patient);
			if (patient2 == null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			else
				return ResponseEntity.of(Optional.of(patient2));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// delete single patient
	public ResponseEntity<Patient> deletePatient(int id) {
		try {
			Patient patient = patientRepository.findById(id);
			patientRepository.deleteById(id);
			if (patient == null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			else
				return ResponseEntity.of(Optional.of(patient));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// update single patient
	public ResponseEntity<Patient> updatePatient(Patient patient, int id) {
		try {
			patient.setId(id);
			patient = patientRepository.save(patient);
			if (patient == null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			else
				return ResponseEntity.of(Optional.of(patient));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
