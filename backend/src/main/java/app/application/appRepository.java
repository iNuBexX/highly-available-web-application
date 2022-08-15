package app.application;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import app.appuser.AppUser;

@Repository
public interface appRepository extends JpaRepository<appEntity, Long>{
	
	@CrossOrigin(origins="*")
    @Query("SELECT a FROM appEntity a  WHERE a.appName = ?1")
	Optional<appEntity> findbyAppName(String appName);
	@Transactional
	@Modifying
	@CrossOrigin(origins="*")
	@Query("UPDATE appEntity a set a=?2 WHERE a.AppId=?1")
	public void updateapp(Long appid,appEntity app);

//@Query("SELECT a FROM appEntity WHERE a.AppId  NOT IN (SELECT b.AppId FROM appEntity b JOIN appDemande c WHERE b.AppId = c.app.AppId")
	//public List<Long> notdemanded();



}