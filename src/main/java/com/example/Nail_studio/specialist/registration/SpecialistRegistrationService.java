package com.example.Nail_studio.specialist.registration;

import com.example.Nail_studio.mail.mail_v1.MailSenderService;
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



    public boolean addSpecialist(SpecialistRegistrationRequest request) {
        if (specialistRepository.findByEmail(request.getEmail()).isPresent())
            return false;

        // TODO: 12/27/2022 make validation before adding to new Specialist
        Specialist specialist = new Specialist(request.getName(),
                                                request.getPassword(),
                                                request.getEmail(),
                                                request.getExperience(),
                                                Role.SPECIALIST,
                                                false,
                                                UUID.randomUUID().toString());

        /*specialist.setActive(false);
        specialist.setRole(Role.SPECIALIST);
<<<<<<< HEAD:src/main/java/com/example/Nail_studio/specialist/registration/SpecialistRegistrationService.java
        specialist.setActivationCode(UUID.randomUUID().toString());*/
=======
        specialist.setActivationCode(UUID.randomUUID().toString());
>>>>>>> 80505ee (change location of registration files/ update files registration):src/main/java/com/example/Nail_studio/registration/SpecialistRegistrationService.java
        specialistRepository.saveAndFlush(specialist);

        // TODO: 12/27/2022 debug this function and open it
        /*String message = String.format("Hello %s, \n" +
                                        "go to link http://localhost:8080/activate/specialist/%s",
                                        specialist.getName(),
                                        specialist.getActivationCode());
        mailSenderService.send(specialist.getEmail(), "registration message from Nail-studio", message);*/
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
