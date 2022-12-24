package com.example.Nail_studio.branchoffice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BranchOfficeRepository extends JpaRepository<BranchOffice, Long> {


    List<BranchOffice> findAll();
    /*@Query("DELETE FROM Specialist s WHERE id = ?1")
    void deleteById(Long id);*/
}
