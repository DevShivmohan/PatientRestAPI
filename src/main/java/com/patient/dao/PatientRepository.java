package com.patient.dao;

import org.springframework.data.repository.CrudRepository;

import com.patient.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
	public Patient findById(int id);
}
