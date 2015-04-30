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
@Table(name="CLIENT_SCHEDULE_INFO")
public class ClientScheduleInfo extends AggregateRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SCHEDULE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long scheduleId;
	
	@Column(name="TS_ID")
	private long tutorScheduleId;
	
	@Column(name="CLIENT_ID")
	private long clientId;
	
	@Column(name="GROUP_ID")
	private long groupId;
	
	@Column(name="SCHEDULE_DT")
	private Date insertDt;
	
	@Column(name="IS_RECURRING")
	private boolean isRecurring;
	
	@Column(name="STATUS")
	private int status;
	
	
	
	@Override
	public Long getId() {
		return scheduleId;
	}

	public long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public long getTutorScheduleId() {
		return tutorScheduleId;
	}

	public void setTutorScheduleId(long tutorScheduleId) {
		this.tutorScheduleId = tutorScheduleId;
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

	public Date getInsertDt() {
		return insertDt;
	}

	public void setInsertDt(Date insertDt) {
		this.insertDt = insertDt;
	}

	public boolean isRecurring() {
		return isRecurring;
	}

	public void setRecurring(boolean isRecurring) {
		this.isRecurring = isRecurring;
	}

	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ClientScheduleInfo(){
		
	}
	
	public ClientScheduleInfo( long clientId, long groupId, long tutorScheduleId, Date insertDt, boolean isRecurring, int status){
		this.setRefId(UUIDGenerator.newRefId());
		this.clientId = clientId;
		this.groupId = groupId;
		this.tutorScheduleId = tutorScheduleId;
		this.insertDt = insertDt;
		this.isRecurring = isRecurring;
		this.status = status;
	}
	
}
