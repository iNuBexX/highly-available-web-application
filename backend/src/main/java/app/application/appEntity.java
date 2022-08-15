package app.application;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.SequenceGenerator;





import app.demande.appDemande;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data


@EqualsAndHashCode

@Entity
public class appEntity {
	@SequenceGenerator( name = "app_sequence", sequenceName = "app_sequence",allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "app_sequence")
	private Long AppId;
	private String appName;
	private String description;
	private String version;
	private String OS;
    @OneToMany(mappedBy="app", fetch=FetchType.EAGER,targetEntity=appDemande.class)
    private Set<appDemande> appDemandes;
	//private appDemande appD;
    
    /*
     * 
     * 
     * 
     * {

	"appName":"myCNIapp",
	"description":"now its better",
	"version":"4",
	"OS":"linux baby"
}
     */
    public appEntity() {}
	public appEntity(String appName,String description,String version,String OS) 
	{
	this.appName=appName;
	this.description=description;
	this.version=version;
	this.OS=OS;
	}
	public Long getappId()
	{
		return AppId;
	}
	public String getappName()
	{
		return appName;
	}
	public String getDescription()
	{
		return description;
	}
	public String getVersion()
	{
		return version;
	}
	public String getOS()
	{
		return OS;
	}
	public void setappname(String name)
	{
	appName=name;	
	}
	
	public void setDesc(String descriptions)
	{
		this.description = descriptions;
	}
	public void setversion(String version)
	{
		this.version = version;
		
	}
	public void setos(String os)
	{
		this.OS = os;
	}
	public void update(appEntity app) {

	}

	 
}
