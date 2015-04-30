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
@Table(name="CLIENT_ENROLLMENT_INFO")
public class ClientEnrollment extends AggregateRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="ENROLLMENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long enrollmentId;
	
	@Column(name="CLIENT_ID")
	private long clientId;

	@Column(name="PRODUCT_ID")
	private long productId;

	@Column(name="INSERT_DT")
	private Date insertDt;
	
	@Override
	public Long getId() {
		return enrollmentId;
	}

	public long getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(long enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public Date getInsertDt() {
		return insertDt;
	}

	public void setInsertDt(Date insertDt) {
		this.insertDt = insertDt;
	}

	public ClientEnrollment() {}
	
	public ClientEnrollment( long clientId, long productId){
		this.setRefId(UUIDGenerator.newRefId());
		this.clientId = clientId;
		this.productId = productId;
		this.insertDt = new Date(System.currentTimeMillis());		
	}
}
