package com.example.Nail_studio.specialist;

import com.example.Nail_studio.branchoffice.BranchOffice;
import com.example.Nail_studio.branchoffice.BranchOfficeRepository;
import com.example.Nail_studio.role.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class SpecialistConfiguration {

    /** Makes for test */
    @Bean(name = "SpecialistConfiguration__commandLineRunner-bean")
    public CommandLineRunner commandLineRunner(SpecialistRepository specialistRepository,
                                               BranchOfficeRepository branchOfficeRepository){
        return args -> {

           /* Specialist igor = new Specialist("Igor", "IgorS@gmail.com", 2, Role.SPECIALIST);

            specialistRepository.save(igor);

            System.out.println(igor);*/


            /*BranchOffice branchOffice = branchOfficeRepository
                    .findById(1L)
                    .orElseThrow(() -> new IllegalStateException("SpecialistConfiguration__commandLineRunner"));

            branchOffice.addSpecialist(igor);
            branchOfficeRepository.save(branchOffice);*/
        };
    }

}
