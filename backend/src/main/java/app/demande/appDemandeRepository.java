package app.demande;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import app.application.appEntity;
import app.appuser.AppUser;



@CrossOrigin(origins="*")
public interface appDemandeRepository extends JpaRepository<appDemande, Long>{
	
	@Query("SELECT a from appDemande a where a.ClientId =?1")
	List<appDemande> findbyclientId(AppUser Client);
	@Transactional
	@Modifying
	@Query("DELETE  from appDemande a where a.app =?1")
	void deletebyApp(appEntity app);

}
