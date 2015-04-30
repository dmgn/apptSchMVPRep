package app.cal.schedule.api;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ApptSchDetails")
@XmlAccessorType(value=XmlAccessType.PROPERTY)
public class AppointmentScheduleDetails extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long tutSchdId;
	
	private long clientId;
	
	private long groupId;
	
	private Date startDt;
	
	private Date endDt;

	boolean isRecurring;
	
	private long timeSlotId;
	
	private long productId;

	private long locId;
	
	private List<Long> selectedDays;
	
	private String status;
	
	@XmlElement(name="startDt", required=false)
	public Date getStartDt() {
		return startDt;
	}

	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	@XmlElement(name="endDt", required=false)
	public Date getEndDt() {
		return endDt;
	}

	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}

	@XmlElement(name="timeSlotId", required=false)
	public long getTimeSlotId() {
		return timeSlotId;
	}

	public void setTimeSlotId(long timeSlotId) {
		this.timeSlotId = timeSlotId;
	}

	@XmlElement(name="prodId", required=false)
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	@XmlElement(name="locId", required=false)
	public long getLocId() {
		return locId;
	}

	public void setLocId(long locId) {
		this.locId = locId;
	}

	@XmlElement(name="tutSchdId", required=false)
	public long getTutSchdId() {
		return tutSchdId;
	}

	public void setTutSchdId(long tutSchdId) {
		this.tutSchdId = tutSchdId;
	}

	@XmlElement(name="clientId", required=false)
	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	@XmlElement(name="groupId", required=false)
	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	@XmlElement(name="isRecurring", required=false)
	public boolean isRecurring() {
		return isRecurring;
	}

	public void setRecurring(boolean isRecurring) {
		this.isRecurring = isRecurring;
	}

	@XmlElement(name="selectedDays", required=false)
	public List<Long> getSelectedDays() {
		return selectedDays;
	}

	public void setSelectedDays(List<Long> selectedDays) {
		this.selectedDays = selectedDays;
	}

	@XmlElement(name="status", required=false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
