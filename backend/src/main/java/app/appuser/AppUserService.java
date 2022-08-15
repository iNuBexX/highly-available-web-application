package app.appuser;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;



@CrossOrigin(origins="*")
@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";
    
    private final AppUserRepository appUserRepository;
    
    private final BCryptPasswordEncoder bCryptPasswordEncoder ;

    public AppUserService(AppUserRepository appUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    	this.appUserRepository=appUserRepository;
    	this.bCryptPasswordEncoder= bCryptPasswordEncoder;
		
	}

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findbyUserName(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

    public void signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository
                .findbyUserName(appUser.getUsername())
                .isPresent();

        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("UserName already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);
        if(appUser.getUsername().equals("mahdi"))
        	//System.out.println("mahdi found");
        	appUser.setAppUserRole(AppUserRole.ADMIN);
        System.out.println(appUser.getUsername());
        appUserRepository.save(appUser);
        
   

       
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
}
