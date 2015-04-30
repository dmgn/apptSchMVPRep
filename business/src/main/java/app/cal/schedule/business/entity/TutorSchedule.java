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
@Table(name="TUTOR_SCHEDULE")
public class TutorSchedule extends AggregateRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name="TUTOR_ID")
	private long tutorId;
	
	
	@Column(name="PRODUCT_ID")
	private long productId;
	
	@Column(name="TIME_SLOT_ID")
	private long timeSlotId;
	
	@Column(name="SCHEDULE_DATE")
	private Date scheduleDate;
	
	
	@Override
	public Long getId() {
		return id;
	}

	
	public long getTutorId() {
		return tutorId;
	}


	public void setTutorId(long tutorId) {
		this.tutorId = tutorId;
	}


	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getTimeSlotId() {
		return timeSlotId;
	}

	public void setTimeSlotId(long timeSlotId) {
		this.timeSlotId = timeSlotId;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}


	public TutorSchedule() {}
	
	public TutorSchedule(long tutorId, long productId, long timeSlotId, Date scheduleDate){
		this.setRefId(UUIDGenerator.newRefId());
		this.tutorId = tutorId;
		this.timeSlotId = timeSlotId;
		this.productId = productId;
		this.scheduleDate = scheduleDate;
	}
}
