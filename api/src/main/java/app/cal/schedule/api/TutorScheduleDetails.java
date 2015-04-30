package app.cal.schedule.api;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="TutorSchDetails")
@XmlAccessorType(value=XmlAccessType.PROPERTY)
public class TutorScheduleDetails extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private long tutorId;
	
	private long tutorScheduleId;
	
	private Date startDate;
	
	private Date endDate;
	
	private long locationId;
	
	private List<Long> prodIds = new LinkedList<>();
	
	private List<Long> timeSlotIds = new LinkedList<>();

	@XmlElement(name="tutorId", required=false)
	public long getTutorId() {
		return tutorId;
	}

	public void setTutorId(long tutorId) {
		this.tutorId = tutorId;
	}

	@XmlElement(name="startDate", required=false)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@XmlElement(name="endDate", required=false)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@XmlElement(name="locId", required=false)
	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	@XmlElement(name="prodIds", required=false)
	public List<Long> getProdIds() {
		return prodIds;
	}

	public void setProdIds(List<Long> prodIds) {
		this.prodIds = prodIds;
	}

	@XmlElement(name="timeSlotIds", required=false)
	public List<Long> getTimeSlotIds() {
		return timeSlotIds;
	}

	public void setTimeSlotIds(List<Long> timeSlotIds) {
		this.timeSlotIds = timeSlotIds;
	}

	@XmlElement(name="tutorScheduleId", required=false)
	public long getTutorScheduleId() {
		return tutorScheduleId;
	}

	public void setTutorScheduleId(long tutorScheduleId) {
		this.tutorScheduleId = tutorScheduleId;
	}
	
	
}
