package app.cal.schedule.common;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum AppointmentStatus {

	
	UNAVAILABLE(0,"UNAVAILABLE"),
	BOOKED(1, "BOOKED"),
	CANCELLED(2, "CANCELLED"),
	COMPLETED(3, "COMPLETED");
	
	 private static final Map<Integer,AppointmentStatus> lookup 
     = new HashMap<>();

	static {
	     for(AppointmentStatus s : EnumSet.allOf(AppointmentStatus.class))
	          lookup.put(s.getCode(), s);
	}
	
	public static AppointmentStatus get(int code) { 
	      return lookup.get(code); 
	}
	 
	int code;
	String text;
	
	AppointmentStatus(int code, String text){
		this.code = code;
		this.text = text;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
