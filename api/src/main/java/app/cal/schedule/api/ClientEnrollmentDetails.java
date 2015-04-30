package app.cal.schedule.api;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ClientEnrollmentDetails")
@XmlAccessorType(value=XmlAccessType.PROPERTY)
public class ClientEnrollmentDetails extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name="enrollId")
	private long enrollId;
	
	@XmlElement(name="clientId")
	private long clientId;

	@XmlElement(name="productId")
	private long productId;
	
	@XmlElement(name="productName")
	private String productName;
	
	@XmlElement(name="enrollDt")
	private Date enrolledDate;

	
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

	public Date getEnrolledDate() {
		return enrolledDate;
	}

	public void setEnrolledDate(Date enrolledDate) {
		this.enrolledDate = enrolledDate;
	}

	public long getEnrollId() {
		return enrollId;
	}

	public void setEnrollId(long enrollId) {
		this.enrollId = enrollId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}
