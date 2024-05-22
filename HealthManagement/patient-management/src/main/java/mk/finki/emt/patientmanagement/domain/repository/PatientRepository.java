package mk.finki.emt.patientmanagement.domain.repository;

import mk.finki.emt.patientmanagement.domain.models.Patient;
import mk.finki.emt.patientmanagement.domain.models.PatientId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, PatientId> {
}
