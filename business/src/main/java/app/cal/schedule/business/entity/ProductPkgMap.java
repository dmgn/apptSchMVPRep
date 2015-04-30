package app.cal.schedule.business.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SERVICE_PACKAGE_MAP")
public class ProductPkgMap extends AggregateRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="SP_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long spId;
	
	
	
	@Override
	public Long getId() {
		return spId;
	}

}
