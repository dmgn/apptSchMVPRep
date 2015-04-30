package app.cal.schedule.api;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ApptResponseDetails")
@XmlAccessorType(value=XmlAccessType.PROPERTY)
public class AppointmentResponseDtls extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="status")
	private String status;
	
	@XmlElement(name="reqDate")
	private Date reqDate;
	
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
	
	@XmlElement(name="clientId")
	private long clientId;

	@XmlElement(name="groupId")
	private long groupId;

	@XmlElement(name="tutorScheduleId")
	private long tutorScheduleId;

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

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

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public long getTutorScheduleId() {
		return tutorScheduleId;
	}

	public void setTutorScheduleId(long tutorScheduleId) {
		this.tutorScheduleId = tutorScheduleId;
	}
	
	
}
