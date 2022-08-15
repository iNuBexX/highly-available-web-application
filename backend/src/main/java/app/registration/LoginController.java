package app.registration;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.appuser.AppUserRepository;

@RestController

public class LoginController {
	private final AppUserRepository UserRepo;
	public LoginController(AppUserRepository UsersRepo)
	{
		this.UserRepo=UsersRepo;
	}
	 @CrossOrigin(origins ="*")
    @RequestMapping(value = "/usernameandstatus", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return this.UserRepo.findbyUserName(principal.getName()).get().getRole();
    }
    @CrossOrigin(origins ="*")
    @RequestMapping(value = "/mylogin", method = RequestMethod.GET)
    @ResponseBody
    public String Login() {
        return	"loggedin";
    }


}
