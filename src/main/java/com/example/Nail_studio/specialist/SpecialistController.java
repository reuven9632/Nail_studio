package com.example.Nail_studio.specialist;

import com.sun.xml.bind.v2.TODO;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping(path = "api/v1/specialist")
@RestController
public class SpecialistController {

    /**
     * {@code @PostAuthorize -> hasRole('ROLE_') hasAnyRole('ROLE_') hasAuthority('permission') hasAnyAuthority('permission')}
     */
    @GetMapping("/all")
    @PostAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    public String getAllSpecialists(){
        // TODO: 1/9/2023 implement business logic for executing this method
        System.out.println("SpecialistController{}  -> getAllSpecialists()  " +
                            "implement business logic for executing this method");
        return "";
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('specialist:add')")
    public String addSpecialist(@RequestBody Specialist specialist,
                                Model model){
        // TODO: 1/9/2023  implement business logic for executing this method
        System.out.println("SpecialistController{}  -> addSpecialist()  " +
                            "implement business logic for executing this method");
        return "";
    }

    @PutMapping("/edit-{idSpecialist}")
    @PostAuthorize("hasAnyRole('ROLE_ADMINISTRATOR','ROLE_SPECIALIST')")
    public String editSpecialist(@PathVariable(name = "idSpecialist") Long idSpecialist,
                                 Model model){
        // TODO: 1/9/2023 delete  'ROLE_SPECIALIST' from @PostAuthorize before deploy
        // TODO: 1/9/2023  implement business logic for executing this method
        System.out.println("SpecialistController{}  -> editSpecialist()  " +
                            "implement business logic for executing this method");
        return "";
    }

    @DeleteMapping("/dell-{idSpecialist}")
    @PostAuthorize("hasAnyAuthority('specialist:delete', 'specialist:edit')")
    public String removeSpecialist(@PathVariable(name = "idSpecialist") Long idSpecialist, Model model){
        // TODO: 1/9/2023  implement business logic for executing this method
        System.out.println("SpecialistController{}  -> removeSpecialist()  " +
                "implement business logic for executing this method");
        return "";
    }
}
