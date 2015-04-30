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

@Entity
@Table(name="TUTOR_SERVICE_MAP")
public class TutorServiceMap  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TUTOR_PROD_MAP_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="TUTOR_ID")
	private Tutor tutor;
	
/*	@Column(name="TUTOR_ID")
	private long tutorId;*/
	
	@Column(name="PRODUCT_ID")
	private long productId;
	
	public Long getId() {
		return id;
	}



/*	public long getTutorId() {
		return tutorId;
	}



	public void setTutorId(long tutorId) {
		this.tutorId = tutorId;
	}*/



	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	
}
