package app.demande;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class appDemandRequest {
	
	private Long demandId;
	private String clientName;
	private	String appName;
	private boolean isCloture;
	private String etat;
	public String getAppName()
	{
		return appName;
	}
	public String getClientName()
	{
		return clientName;
	}

		public Long getDemandId()
		{
			return demandId;
		}
	public boolean getIsCloture()
	{
		return isCloture;
	}
	public String getEtat()
	{
		return etat;
	}
	
	
}
