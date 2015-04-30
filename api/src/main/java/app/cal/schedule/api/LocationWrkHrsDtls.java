package app.cal.schedule.api;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="LocationWrkHrsDtls")
@XmlAccessorType(value=XmlAccessType.PROPERTY)
public class LocationWrkHrsDtls extends BaseMessage{

	private static final long serialVersionUID = 1L;

	@XmlElement(name="timeSlotId")
	private long timeSlotId;
	
	@XmlElement(name="startTime")
	private String startTime;
	
	@XmlElement(name="endTime")
	private String endTime;
	
	@XmlElement(name="locationId")
	private long locationId;

	@XmlElement(name="locationName")
	private String locationName;
	
	public long getTimeSlotId() {
		return timeSlotId;
	}

	public void setTimeSlotId(long timeSlotId) {
		this.timeSlotId = timeSlotId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
}
