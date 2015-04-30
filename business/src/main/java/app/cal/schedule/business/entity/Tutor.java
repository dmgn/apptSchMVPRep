package app.cal.schedule.business.entity;

import java.util.HashSet;
import java.util.Set;

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
@Table(name="TUTOR_INFO")
public class Tutor extends AggregateRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TUTOR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="TUTOR_NAME")
	private String tutorName;
	
	@Column(name="CORPORATE_ID")
	private long corpId;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true, mappedBy="tutor")
	//@JoinColumn(name="TUTOR_ID", referencedColumnName="TUTOR_ID")
	private Set<TutorServiceMap> tsMap = new HashSet<>();
	
	/*@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="tutor" )
	private Set<TutorSchedule> set = new HashSet<>();
*/
	@Override
	public Long getId() {
		return id;
	}
	
	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}
	
	public long getCorpId() {
		return corpId;
	}

	public void setCorpId(long corpId) {
		this.corpId = corpId;
	}

	
	public Set<TutorServiceMap> getTsMap() {
		return tsMap;
	}

	public void setTsMap(Set<TutorServiceMap> tsMap) {
		this.tsMap = tsMap;
	}

	public Tutor() {}
	
	public Tutor(String tutorName, long corpId){
		this.setRefId(UUIDGenerator.newRefId());
		this.tutorName = tutorName;
		this.corpId = corpId;
	}
}
