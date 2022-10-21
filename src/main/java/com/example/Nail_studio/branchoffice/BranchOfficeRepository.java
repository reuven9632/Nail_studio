package com.example.Nail_studio.branchoffice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchOfficeRepository extends JpaRepository<BranchOffice, Long> {

    /*@Query("DELETE FROM specialist WHERE id = ?1")
    void deleteById(Long id);*/
}
