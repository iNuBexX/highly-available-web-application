package app.registration;

import app.appuser.AppUser;
import app.appuser.AppUserRole;
import app.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    public RegistrationService(AppUserService appUserService)
    {
    	this.appUserService = appUserService;
    }


    public void register(RegistrationRequest request) {


       appUserService.signUpUser(
                new AppUser(
                        request.getUserName(),
                        request.getPassword(),
                        AppUserRole.USER

                )
        );



     //   return token;
    }



  }
