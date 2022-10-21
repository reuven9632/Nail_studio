package com.example.Nail_studio.options;

import com.example.Nail_studio.branchoffice.BranchOfficeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OptionsConfiguration {

    /** Makes for test */
//    @Bean(name = "OptionsConfiguration__commandLineRunner-bean")
    public CommandLineRunner commandLineRunner (OptionsRepository optionsRepository,
                                                BranchOfficeRepository branchOfficeRepository){
        return args -> {
           /* Options option = new Options("Create first option",
                                        true,
                                        true,
                                        6,
                                        true,
                                        2,
                                        true,
                                        2,
                                        branchOfficeRepository
                                                .findById(1L)
                                                .orElseThrow(() ->
                                                        new IllegalStateException("OptionsConfiguration__commandLineRunner :  branchOfficeRepository is not find branchOffice with id = 1L") ));
            System.out.println(option);
            optionsRepository.save(option);


            System.out.println(option);

*/
        };
    }

}
