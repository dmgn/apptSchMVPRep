package app.cal.schedule.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CorpLocDetails")
@XmlAccessorType(value=XmlAccessType.PROPERTY)
public class CorpLocDetails extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long locationId;
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String zipCode;
	
	private String country;
	
	private String timezone;

	@XmlElement(name="locId", required=false)
	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	@XmlElement(name="street", required=false)
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@XmlElement(name="city", required=false)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@XmlElement(name="state", required=false)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@XmlElement(name="zipCode", required=false)
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@XmlElement(name="tZone", required=false)
	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	@XmlElement(name="ctry", required=false)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
