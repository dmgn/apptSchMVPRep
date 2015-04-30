package app.cal.schedule.api;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="TutorDetails")
@XmlAccessorType(value=XmlAccessType.PROPERTY)
public class TutorDetails extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long tutorId;
	
	private String tutorName;
	
	private List<Long> productIds = new LinkedList();
	
	private List<String> productNames = new LinkedList();

	
	@XmlElement(name="tutorId", required=false)
	public long getTutorId() {
		return tutorId;
	}

	public void setTutorId(long tutorId) {
		this.tutorId = tutorId;
	}

	@XmlElement(name="tutorName", required=false)
	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	@XmlElement(name="productIds", required=false)
	public List<Long> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
		this.productIds.addAll(productIds);
	}

	@XmlElement(name="productNames", required=false)
	public List<String> getProductNames() {
		return productNames;
	}

	public void setProductNames(List<String> productNames) {
		this.productNames.addAll(productNames);
	}

	
	
}
