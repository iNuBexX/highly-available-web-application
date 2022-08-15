package app.application;


import lombok.EqualsAndHashCode;
import lombok.ToString;



@EqualsAndHashCode
@ToString
public class appRequest {

	private String appName;
	private String description;
	private String version;
	private String os;
	public appRequest(String appName,
	 String description,
	String version,
	 String OS)
	{
		 this.appName=appName;
		 this.description=description;
		 this.version=version;
		 this.os=os;
	}
	
	
	public String getAppName()
	{
		return appName;
	}
	public String getAppDescription()
	{
		return description;
	}
	public String getVersion()
	{
		return version;
	}
	public String getOS()
	{
		return os;
	}
}
