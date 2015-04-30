package app.cal.schedule.business.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import app.cal.schedule.common.UUIDGenerator;

@Entity
@Table(name="CLIENT_INFO")
public class ClientInfo extends AggregateRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="CLIENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Override
	public Long getId() {
		return id;
	}
	
/*	@Column(name="GROUP_ID")
	private long groupId;*/
	
	@Column(name="CORPORATE_ID")
	private long corpId;
	
	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="DOB")// BirthDay Poller
	private Date dob;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNo;
	
	@Column(name="INSERT_TS")
	private Date insertTS;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GROUP_ID")
	private ClientGroup clientGrp;
	
	public long getCorpId() {
		return corpId;
	}

	public void setCorpId(long corpId) {
		this.corpId = corpId;
	}

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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public Date getInsertTS() {
		return insertTS;
	}

	public void setInsertTS(Date insertTS) {
		this.insertTS = insertTS;
	}

	public void setId(long id) {
		this.id = id;
	}	
	
	public ClientGroup getClientGrp() {
		return clientGrp;
	}

	public void setClientGrp(ClientGroup clientGrp) {
		this.clientGrp = clientGrp;
	}

	public ClientInfo(){
		
	}
	
	public ClientInfo( long corpId,
			String fName,
			String lName,
			Date dob,
			String emailId,
			String phoneNo){
		this.setRefId(UUIDGenerator.newRefId());
		this.setInsertTS(new Date(System.currentTimeMillis()));
		this.corpId = corpId;
		this.firstName = fName;
		this.lastName = lName;
		this.dob = dob;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
	}
	
}
