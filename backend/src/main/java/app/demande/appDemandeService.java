package app.demande;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.application.appEntity;
import app.application.appRepository;
import app.appuser.AppUser;
import app.appuser.AppUserRepository;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class appDemandeService {
	private final AppUserRepository As;
	private final appRepository appRepo;
	private final appDemandeRepository appDemandRepo;
	public appDemandeService(AppUserRepository As,appRepository appRepo,appDemandeRepository appDemandRepo) {
		this.As=As;
		this.appRepo = appRepo;
		this.appDemandRepo = appDemandRepo;
	}
	public String makeDemand(appDemandRequest myDemandrequest) {
    AppUser user= As.findbyUserName(myDemandrequest.getClientName()).get();
    appEntity app= appRepo.findbyAppName(myDemandrequest.getAppName()).get();
    if(user != null && app!= null)
    {  
    System.out.println("all checks out");
	appDemandRepo.save(new appDemande(user,app,LocalDate.now()));
	return "OK";
	}
    return "not ok";
    }
	public List<appDemande> getAllDemands() {
		return appDemandRepo.findAll();
	}
	public List<appDemande> getdamndsforclient(appDemandRequest request) {
		
		AppUser user =  As.findbyUserName(request.getClientName()).get();
		return appDemandRepo.findbyclientId(user);
	}
	public void updaterequest(appDemandRequest app) {
		//this.appDemandRepo.findbyclientId(null)
		appDemande demand =this.appDemandRepo.findById(app.getDemandId()).get();
		if (app.getIsCloture())
			demand.cloturer();
		demand.setEtat(app.getEtat());
			appDemandRepo.save(demand);
		
	}
	

}
