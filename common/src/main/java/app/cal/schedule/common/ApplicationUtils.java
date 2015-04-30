package app.cal.schedule.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationUtils {

	
	public static List<Date> getListofDates(Date startDate, Date endDate){
		List<Date> dates = new ArrayList<Date>();
		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		long interval = 24*1000 * 60 * 60; // 1 hour in millis
		long endTime = endDate.getTime() ; 
		long curTime = startDate.getTime();
		while (curTime <= endTime) {
		    dates.add(new Date(curTime));
		    curTime += interval;
		}
		return dates;
	}
	
}
