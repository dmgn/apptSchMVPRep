package app.cal.schedule.business.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import app.cal.schedule.common.UUIDGenerator;

@Entity
@Table(name="PRODUCT_INFO")
public class Product extends AggregateRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="PRODUCT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="CORPORATE_ID")
	private long corpId;

	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="UNIT_PRICE")
	private Double unitPrice;

	@Column(name="ROOM_CAPACITY")
	private long roomCapacity;
	
	
	public String getProductName() {
		return productName;
	}


	public Double getUnitPrice() {
		return unitPrice;
	}


	@Override
	public Long getId() {
		return id;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
	
	public long getCorpId() {
		return corpId;
	}


	public void setCorpId(int corpId) {
		this.corpId = corpId;
	}

	public long getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(long roomCapacity) {
		this.roomCapacity = roomCapacity;
	}

	public Product(){}

	public Product( final String productName, final Double unitPrice, long corpId, long roomCapacity){
		this.setRefId(UUIDGenerator.newRefId());
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.corpId = corpId;
		this.roomCapacity = roomCapacity;
	}
}
