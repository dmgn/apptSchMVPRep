package app.cal.schedule.api;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CorporateDetails")
@XmlAccessorType(value=XmlAccessType.PROPERTY)
public class CorporateDetails extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long corporateId;
	
	private String corporateName;

	private List<CorpLocDetails> corpLocDetails = new LinkedList<>();
	
	@XmlElement(name="corpId", required=false)
	public long getCorporateId() {
		return corporateId;
	}

	public void setCorporateId(long corporateId) {
		this.corporateId = corporateId;
	}

	@XmlElement(name="corpName", required=false)
	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	@XmlElement(name="corpLocs", required=false)
	public List<CorpLocDetails> getCorpLocDetails() {
		return corpLocDetails;
	}

	public void setCorpLocDetails(List<CorpLocDetails> corpLocDetails) {
		this.corpLocDetails = corpLocDetails;
	}

}
