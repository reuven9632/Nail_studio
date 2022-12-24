package com.example.Nail_studio.branchoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RequestMapping(path = "api/v1/branch_office")
@RestController
public class BranchOfficeController {

    private BranchOfficeService branchOfficeService;

    @GetMapping(path = "/all")
    public List<BranchOffice> allBranchOffice(Model model){
        List<BranchOffice> branchOffices = branchOfficeService.allBranchOffice();
        model.addAttribute("branchOffices", branchOffices);
        return branchOffices;
        // TODO: 12/16/2022 create "order" view to choice BranchOffice
    }
}
