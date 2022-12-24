package com.example.Nail_studio.specialist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecialistRepository extends JpaRepository<Specialist, Long> {

    Optional<Specialist> findByEmail(String email);

    Specialist findByActivationCode(String activationCode);

    /*@Query("DELETE FROM specialist WHERE id = ?1")
    void deleteById(Long id);*/
}
