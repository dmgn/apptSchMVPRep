package app.cal.schedule.business.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import app.cal.schedule.common.UUIDGenerator;

@Entity
@Table(name="LOCATION_WORK_HRS")
public class LocationWorkHours extends AggregateRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TIME_SLOT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="START_TIME")
	private String startTime;

	@Column(name="END_TIME")
	private String endTime;
	
	@Column(name="LOCATION_ID")
	private long locationId;
	
	@Override
	public Long getId() {
		return id;
	}

	public void setTimeSlotId(long timeSlotId) {
		this.id = timeSlotId;
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

	public LocationWorkHours(){}
	
	public LocationWorkHours( String startTime, String endTime, long locationId){
		this.setRefId(UUIDGenerator.newRefId());
		this.startTime = startTime;
		this.endTime = endTime;
		this.locationId = locationId;
	}
		
}
