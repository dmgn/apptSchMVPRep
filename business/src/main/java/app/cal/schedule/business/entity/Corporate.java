package app.cal.schedule.business.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import app.cal.schedule.common.UUIDGenerator;


@Entity
@Table(name="CORPORATE_INFO")
public class Corporate extends AggregateRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="CORPORATE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true, mappedBy="corp")
	private List<CorporateLocation> corpLocList = new LinkedList<>();
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Column(name="CORPORATE_NAME")
	private String corpName;

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public List<CorporateLocation> getCorpLocList() {
		return corpLocList;
	}

	public void setCorpLocList(List<CorporateLocation> corpLocList) {
		this.corpLocList = corpLocList;
	}

	public Corporate(String corpName){
		this.setRefId(UUIDGenerator.newRefId());
		this.corpName = corpName;
	}
	
	public Corporate(){}
}
