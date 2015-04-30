package app.cal.schedule.api;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ClientInfoDetails")
@XmlAccessorType(value=XmlAccessType.PROPERTY)

public class ClientInfoDetails extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="clientId")
	private long clientId;
	
	@XmlElement(name="fName")
	private String firstName;
	

	@XmlElement(name="lName")
	private String lastName;
	

	@XmlElement(name="emailId")
	private String emailId;
	
	@XmlElement(name="phoneNo")
	private String phoneNo;

	@XmlElement(name="dob")
	private Date dob;

	@XmlElement(name="group")
	private ClientGroupDetails group;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public ClientGroupDetails getGroup() {
		return group;
	}

	public void setGroup(ClientGroupDetails group) {
		this.group = group;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
}
