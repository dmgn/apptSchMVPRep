package app.cal.schedule.api;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="BaseMsg")
@XmlAccessorType(value=XmlAccessType.PROPERTY)
public class BaseMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SystemMessages systemMessages;
	
	private String requestId;
	
	private Date lastUpdated;
	
	private int source;
	
	private String referenceId;
	
	private int version;
	
	private long corpId;
	
	private String resultStatus;

	@XmlElement(name="reqId", required=false)
	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	@XmlElement(name="timest", required=false)
	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@XmlElement(name="source", required=false)
	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	@XmlElement(name="refId", required=false)
	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	@XmlElement(name="version", required=false)
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@XmlElement(name="msgs", required=false)
	public SystemMessages getSystemMessages() {
		return systemMessages;
	}

	public void setSystemMessages(SystemMessages systemMessages) {
		this.systemMessages = systemMessages;
	}

	@XmlElement(name="corpId", required=false)
	public long getCorpId() {
		return corpId;
	}

	public void setCorpId(long corpId) {
		this.corpId = corpId;
	}

	@XmlElement(name="Result", required=false)
	public String getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

}
