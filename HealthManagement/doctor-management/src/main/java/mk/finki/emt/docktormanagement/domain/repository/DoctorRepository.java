package mk.finki.emt.docktormanagement.domain.repository;

import mk.finki.emt.docktormanagement.domain.model.Doctor;
import mk.finki.emt.docktormanagement.domain.model.DoctorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, DoctorId> {
}
