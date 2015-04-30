package app.cal.schedule.api;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="ClientSvcPkgInfoDetails")
@XmlAccessorType(value=XmlAccessType.PROPERTY)

public class ClientSvcPkgInfoDetails extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long enrollId;
	
	private long productId;
	
	private long packageId;
	
	private Date pkgStartDate;
	
	private Date pkgEndDate;
	
	private Date insertDate;

	@XmlElement(name="enrollId", required=false)
	public long getEnrollId() {
		return enrollId;
	}

	public void setEnrollId(long enrollId) {
		this.enrollId = enrollId;
	}

	@XmlElement(name="productId", required=false)
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	@XmlElement(name="packageId", required=false)
	public long getPackageId() {
		return packageId;
	}

	public void setPackageId(long packageId) {
		this.packageId = packageId;
	}

	@XmlElement(name="pkgStartDate", required=false)
	public Date getPkgStartDate() {
		return pkgStartDate;
	}

	public void setPkgStartDate(Date pkgStartDate) {
		this.pkgStartDate = pkgStartDate;
	}

	@XmlElement(name="pkgEndDate", required=false)
	public Date getPkgEndDate() {
		return pkgEndDate;
	}

	public void setPkgEndDate(Date pkgEndDate) {
		this.pkgEndDate = pkgEndDate;
	}

	@XmlElement(name="insertDate", required=false)
	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	
	
}
