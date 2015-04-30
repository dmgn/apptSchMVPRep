package app.cal.schedule.business.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AggregateRoot extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Version
	private int version;
	

	@Column(name="REF_ID")
	private String refId;


	public int getVersion() {
		return version;
	}


	public String getRefId() {
		return refId;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public void setRefId(String refId) {
		this.refId = refId;
	}
	
	
	
}
