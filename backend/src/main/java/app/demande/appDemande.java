package app.demande;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import app.application.appEntity;
import app.appuser.AppUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data


@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "appDemande")
public class appDemande {
	@SequenceGenerator( name = "demand_sequence", sequenceName = "demand_sequence",allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "demand_sequence")
	@Column(name="DemandId")

	private Long DemandId;
    @ManyToOne
    @JoinColumn(name="AppId", nullable=false)
	private appEntity app;
    @ManyToOne
    @JoinColumn(name="AppUser", nullable=false)
    private AppUser ClientId;
    private String appName;
    private String clientName;
	private LocalDate creation;
	private LocalDate cloture;

	@Enumerated(EnumType.STRING)
	private Etat etat;
	public appDemande()
	{
		
	}
	public appDemande(AppUser client ,appEntity app,LocalDate creation) 
	{

	this.ClientId = client;
	this.app=app;
	this.appName=app.getappName();
	this.clientName= client.getUsername();
	this.creation=creation;
	this.etat = Etat.ENATTENTE;
	}
	public Long getDemandId()
	{
		return DemandId;
	}


	public String getclientName()
	{
		return ClientId.getUsername();
	}
	public String getappName()
	{
		return appName;
	}

	public LocalDate  getCreation()
	{
		return creation;
	}
	public LocalDate getCloture()
	{
		return cloture;
	}
	public String getEtat()
	{
		return etat.name();
	}
	public void cloturer()
	{
		this.cloture=LocalDate.now();
		etat=Etat.CLOTURE;
	}
	public void setEtat(String etat2) {
		
		if( etat2.equals("ENATTENTE"))
		{				etat = Etat.ENATTENTE;
		cloture=null;}
		if (etat2.equals("ENCOURS"))
			{etat=Etat.ENCOURS;
			cloture=null;
			System.out.println(etat2);
			}
		if (etat2.equals("CLOTURE"))
			etat=Etat.CLOTURE;
				
		
	}
	

	 
}
