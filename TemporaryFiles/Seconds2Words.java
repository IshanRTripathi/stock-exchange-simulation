package com.mthree;

public class Seconds2Words {

	String str = "";
	String str2 = "";
	String str4 = "";
	String str5 = "";

	public String secondstowords(long sec) {
		String str3 = "";
		long secs = sec;
		if (secs < 60) {
			if (secs < 2)
			{   
				str3 = secs + " second";
				
			}
			else
				str3 = secs + " seconds";

		} else if (secs >= 60 && secs < 3600) {
			str3 = MinsAndSecs(secs);
		} 
		
		else if(secs>= 3600 && secs < 86400) {
			str3 = HoursMinsSecs(secs);
		}
		
		else
		{
			str3=DaysHoursMinsSecs(secs);
		}
		return str3;

	}

	
	
	public String MinsAndSecs(long secs) {
		long min = secs / 60;
		long secs1 = secs % 60;
		String str3 = "";
		if (min < 2)
		{    
			str = min + " minute";
			
		}
		else
			str = min + " minutes";

		str2 = secondstowords(secs1);

		str3 = str + " " + str2;
		return str3;

	}

	
	
	
	
	public String HoursMinsSecs(long secs) {
		long hr = secs / 3600;
		long mins = secs % 3600;
		str4 = MinsAndSecs(mins);
		if (hr < 2)
			str = hr + " hour";
		else
			str = hr + " hours";

		str5 = str + " " + str4;
		return str5;
	}
	
	
	
	
	

	public String DaysHoursMinsSecs(long secs) {
		long day = secs / 86400;
		long hr = secs % 86400;
		str4 = HoursMinsSecs(hr);
		if (day < 2)
			str = day + " day";
		else
			str = day + " days";

		str5 = str + " " + str4;
		return str5;
	}


}
