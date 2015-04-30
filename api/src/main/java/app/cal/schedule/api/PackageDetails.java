package app.cal.schedule.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="PackageDetails")
@XmlAccessorType(value=XmlAccessType.PROPERTY)
public class PackageDetails extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long packageId;
	
	private String packageName;
	
	private int packageDuration;
	
	private String packageDesc;

	private String packageOfferCode;
	
	@XmlElement(name="pkgId", required=false)
	public long getPackageId() {
		return packageId;
	}

	public void setPackageId(long packageId) {
		this.packageId = packageId;
	}

	@XmlElement(name="pkgName", required=false)
	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	@XmlElement(name="pkgDur", required=false)
	public int getPackageDuration() {
		return packageDuration;
	}

	public void setPackageDuration(int packageDuration) {
		this.packageDuration = packageDuration;
	}

	@XmlElement(name="desc", required=false)
	public String getPackageDesc() {
		return packageDesc;
	}

	public void setPackageDesc(String packageDesc) {
		this.packageDesc = packageDesc;
	}

	@XmlElement(name="offerCode", required=false)
	public String getPackageOfferCode() {
		return packageOfferCode;
	}

	public void setPackageOfferCode(String packageOfferCode) {
		this.packageOfferCode = packageOfferCode;
	}
	
}
