package app.cal.schedule.business.entity;

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
@Table(name="CORPORATE_LOCATION_INFO")
public class CorporateLocation extends AggregateRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LOCATION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="CITY")
	private String city;

	@Column(name="STATE")
	private String state;
	
	@Column(name="ZIP_CODE")
	private String zipCode;
	
	@Column(name="TIME_ZONE")
	private String timeZone;
	
	@Column(name="COUNTRY")
	private String country;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CORPORATE_ID")
	private Corporate corp;
	
	@Override
	public Long getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Corporate getCorp() {
		return corp;
	}

	public void setCorp(Corporate corp) {
		this.corp = corp;
	}

	public CorporateLocation(){
		
	}
	
    public CorporateLocation( String street, String city, String state, String zipCode, String timezone, String country){
		this.setRefId(UUIDGenerator.newRefId());
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.timeZone = timezone;
	}
}
