package app.cal.schedule.business.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Embedded
	private AuditRecord auditRecord;
	
	@Column(name="update_date", insertable=true, updatable=true)
	private Date lastUpdated = new Date();
	
	public abstract Long getId();

	public AuditRecord getAuditRecord() {
		return auditRecord;
	}

	public void auditChange() {
		this.auditRecord = new AuditRecord("test", 9, "test");
		this.lastUpdated = new Date();
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

		
	
}
