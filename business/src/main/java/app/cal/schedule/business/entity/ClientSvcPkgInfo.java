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
@Table(name="CLIENT_PRODUCT_PKG_INFO")
public class ClientSvcPkgInfo extends AggregateRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="ENROLLMENT_ID")
	private long enrollmentId;
	
	@Column(name="PRODUCT_ID")
	private long productId;

	@Column(name="PACKAGE_ID")
	private long packageId;

	@Column(name="PKG_START_DT")
	private Date startDate;

	@Column(name="PKG_END_DT")
	private Date endDate;
	
	@Column(name="INSERT_DT")
	private Date insertDate;
	
		
	@Override
	public Long getId() {
		return id;
	}


	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public long getPackageId() {
		return packageId;
	}


	public void setPackageId(long packageId) {
		this.packageId = packageId;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public long getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentRefId(long enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public ClientSvcPkgInfo(){
		
	}
	
	public ClientSvcPkgInfo( long enrollmentId,
			long productId,
			long packageId,
			Date startDate,
			Date endDate){
		this.setRefId(UUIDGenerator.newRefId());
		this.insertDate = new Date();
		this.enrollmentId = enrollmentId;
		this.packageId = packageId;
		this.productId = productId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
}
