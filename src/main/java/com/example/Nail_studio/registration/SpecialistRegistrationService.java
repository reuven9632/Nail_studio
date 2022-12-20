package com.example.Nail_studio.registration;

import com.example.Nail_studio.mail.MailSenderService;
import com.example.Nail_studio.role.Role;
import com.example.Nail_studio.specialist.Specialist;
import com.example.Nail_studio.specialist.SpecialistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

// TODO: 12/20/2022 on this class has many of code same as ClientRegistrationService, need upgrade this code  
@AllArgsConstructor
@Service
public class SpecialistRegistrationService {

    private SpecialistRepository specialistRepository;
    private MailSenderService mailSenderService;



    public boolean addSpecialist(Specialist specialist) {
        if (specialistRepository.findByEmail(specialist.getEmail()).isPresent())
            return false;

        specialist.setActive(false);
        specialist.setRole(Role.SPECIALIST);
        specialist.setActivationCode(UUID.randomUUID().toString());
        specialistRepository.save(specialist);

        String message = String.format("Hello %s, \n" +
                                        "go to link http://localhost:8080/activate/%s",
                                        specialist.getName(),
                                        specialist.getActivationCode());
        mailSenderService.send(specialist.getEmail(), "registration message from Nail-studio",message);
        return true;
    }

    public boolean activation(String activationCode) {
        Specialist specialist = specialistRepository.findByActivationCode(activationCode);

        if (specialist == null) 
            return false;
        
        specialist.setActivationCode(null);
        specialist.setActive(true);
        specialistRepository.save(specialist);
        return true;
    }
}
