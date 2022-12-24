package com.example.Nail_studio.branchoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class BranchOfficeService {

    private BranchOfficeRepository branchOfficeRepository;

    public List<BranchOffice> allBranchOffice() {
        return branchOfficeRepository.findAll();
    }
}
