package app.cal.schedule.business.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import app.cal.schedule.common.UUIDGenerator;


@Entity
@Table(name="PACKAGE_INFO")
public class Package extends AggregateRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PACKAGE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="PACKAGE_NAME")
	private String packageName;
	
	@Column(name="PACKAGE_DURATION")
	private int packageDuration;
	
	@Column(name="PACKAGE_DESC")
	private String packageDesc;
	
	@Column(name="PACKAGE_OFFER_CODE")
	private String packageOfferCode;
	
	@Column(name="CORPORATE_ID")
	private long corpId;
	
	@Override
	public Long getId() {
		return id;
	}

	public String getPackageName() {
		return packageName;
	}

	public int getPackageDuration() {
		return packageDuration;
	}

		
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public void setPackageDuration(int packageDuration) {
		this.packageDuration = packageDuration;
	}
	
	public String getPackageDesc() {
		return packageDesc;
	}

	public void setPackageDesc(String packageDesc) {
		this.packageDesc = packageDesc;
	}

	public String getPackageOfferCode() {
		return packageOfferCode;
	}

	public void setPackageOfferCode(String packageOfferCode) {
		this.packageOfferCode = packageOfferCode;
	}

	
	public long getCorpId() {
		return corpId;
	}

	public void setCorpId(long corpId) {
		this.corpId = corpId;
	}

	public Package( final String pkgName, int pkgDuration, final String pkgOfferCode, String pkgDesc, long corpId ){
		this.setRefId(UUIDGenerator.newRefId());
		this.packageName = pkgName;
		this.packageDuration = pkgDuration;
		this.packageOfferCode = pkgOfferCode;
		this.packageDesc = pkgDesc;
		this.corpId = corpId;
	}
	
	public Package(){}
	
}
