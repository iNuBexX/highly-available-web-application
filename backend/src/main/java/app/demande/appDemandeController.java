package app.demande;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/demandes")

public class appDemandeController {
	
	private final appDemandeService myappDemandService;
	public appDemandeController(appDemandeService myappDemandService)
	{
		this.myappDemandService = myappDemandService;
	}
	@CrossOrigin(origins = "*")
	@PostMapping
	 public void makeDemand(@RequestBody appDemandRequest myDemandrequest) {
		System.out.println("request Made");
		myappDemandService.makeDemand(myDemandrequest);
		
		
	}
	@PatchMapping
	public void updatedemand(@RequestBody appDemandRequest app)
	{
		//System.out.println(app.getDemandId());
		//System.out.println(app.getIsCloture());
	//	System.out.println(app.getEtat());
	this.myappDemandService.updaterequest(app);
	
	}
	
	@GetMapping
	public List<appDemande> listdemands()
	{
		return myappDemandService.getAllDemands();
	}
	@PostMapping(path="/specific")
	public List<appDemande> listdemandsforclient(@RequestBody appDemandRequest request) 
	{
	
		return myappDemandService.getdamndsforclient(request);
	}


 
}
