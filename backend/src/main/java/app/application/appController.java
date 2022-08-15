package app.application;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.appuser.AppUser;
import app.appuser.AppUserRepository;
import app.demande.appDemandeRepository;


@RestController
@CrossOrigin(origins="*")
@RequestMapping(path = "api/applications")
public class appController {
	private final appDemandeRepository appDemandRepo;
	private appRepository appRepo;
	private final AppUserRepository As;
	public appController( appRepository appRepo, appDemandeRepository appDemandRepo, AppUserRepository As)
	{
		this.As=As;
		this.appDemandRepo=appDemandRepo;
		this.appRepo = appRepo;
	}
	@PostMapping(path="/delete")
	public void deleteapp(@RequestBody appRequest myRequest)
	{
	this.appDemandRepo.deletebyApp(this.appRepo.findbyAppName(myRequest.getAppName()).get());
	this.appRepo.delete(appRepo.findbyAppName(myRequest.getAppName()).get());	
	}
	@PostMapping
	public void addapplications(@RequestBody appRequest myRequest)
	{
		System.out.println("new app received");
		appRepo.save(new appEntity(myRequest.getAppName(),myRequest.getAppDescription(),myRequest.getVersion(),myRequest.getOS()));
	}
	@CrossOrigin(origins="*")
	@GetMapping
	@ResponseBody
	public List<appEntity> listapplications()
	{
		return appRepo.findAll();
	}
	@CrossOrigin(origins="*")
	@PatchMapping
	public void updateapplications(@RequestBody appRequest myRequest)
	{
		System.out.println(myRequest.getAppName());
		appEntity application = new appEntity(myRequest.getAppName(),myRequest.getAppDescription(),myRequest.getVersion(),myRequest.getOS());
		if(appRepo.findbyAppName(application.getappName()).isPresent())
		{
		appEntity	app = appRepo.findbyAppName(application.getappName()).get();
		if(myRequest.getAppName()!=null)
			app.setappname(myRequest.getAppName());
		if(myRequest.getAppDescription()!=null)
			app.setDesc(myRequest.getAppDescription());
		if(myRequest.getVersion()!=null)
			app.setversion(myRequest.getVersion());
		if(myRequest.getOS()!=null)
			app.setos(myRequest.getOS());
		//appRepo.updateapp(app.getappId(),app);
		appRepo.save(app);
		}
		
		else 
		System.out.println("app to be updated does not exist");
		
	}
	@CrossOrigin(origins="*")
	@GetMapping("/")
	public String login()
	{
		return "logged in";
	}





}
