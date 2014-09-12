package me.fil.texpansion;

import java.net.MalformedURLException;

public class ApiManager 
{
	
	public static enum API
	{
		CAPE, DEV, PASTEBIN;
	}
	
	static String getEncryptedApi(API api)
	{
		if(api == API.CAPE)
		{
	    	TExpansion.logger.info("Fetching API Details...");
	    	try {
				Thread.sleep(7500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return I18N.getString(api);
		}
		return null;
	}
}
