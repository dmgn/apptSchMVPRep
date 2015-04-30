package app.cal.schedule.api;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="TutorSchRespDetails")
@XmlAccessorType(value=XmlAccessType.PROPERTY)
public class TutorScheduleResponseDtls extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long tutorScheduleId;
	
	private Date scheduleDate;
	
	private String prodName;
	
	private String startTime;
	
	private String endTime;
	
	private long locationId;

	@XmlElement(name="tutorSchdId", required=false)
	public long getTutorScheduleId() {
		return tutorScheduleId;
	}

	public void setTutorScheduleId(long tutorScheduleId) {
		this.tutorScheduleId = tutorScheduleId;
	}

	@XmlElement(name="scheduleDt", required=false)
	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	@XmlElement(name="prodName", required=false)
	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@XmlElement(name="startTime", required=false)
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@XmlElement(name="endTime", required=false)
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@XmlElement(name="locId", required=false)
	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}
	
	
	
}
