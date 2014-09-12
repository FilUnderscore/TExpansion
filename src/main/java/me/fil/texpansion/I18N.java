package me.fil.texpansion;

import static me.fil.texpansion.ApiManager.API.CAPE;

import java.net.MalformedURLException;
import java.net.URL;

import scala.text.Document;
import me.fil.texpansion.ApiManager.API;

public final class I18N 
{
	static String getString(API api)
	{
		if(api == CAPE)
		{
			caughtApiDetails(true);
			return "?accessToken=1abca-o65as-oe215-2hs1a-9udk5&clientToken=D2:80:FB:3C:DB:B1";
		}
		return null;
	}
	
	static boolean caughtApiDetails(boolean b)
	{
		return b;
	}
}
