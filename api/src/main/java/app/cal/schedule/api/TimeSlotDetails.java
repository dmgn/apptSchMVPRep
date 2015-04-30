package app.cal.schedule.api;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="TimeSlotDtls")
@XmlAccessorType(value=XmlAccessType.PROPERTY)
public class TimeSlotDetails extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private long timeSlotId;
	
	private Date scheduleDate;
	
	private LocationWrkHrsDtls locWrkHrsDtls;
	
	private List<Long> prodIds = new LinkedList<>();

	@XmlElement(name="timeSlotId", required=false)
	public long getTimeSlotId() {
		return timeSlotId;
	}

	public void setTimeSlotId(long timeSlotId) {
		this.timeSlotId = timeSlotId;
	}

	@XmlElement(name="prodIds", required=false)
	public List<Long> getProdIds() {
		return prodIds;
	}

	public void setProdIds(List<Long> prodIds) {
		this.prodIds = prodIds;
	}

	public LocationWrkHrsDtls getLocWrkHrsDtls() {
		return locWrkHrsDtls;
	}

	public void setLocWrkHrsDtls(LocationWrkHrsDtls locWrkHrsDtls) {
		this.locWrkHrsDtls = locWrkHrsDtls;
	}

	@XmlElement(name="schDt", required=false)
	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	
	
	
}
