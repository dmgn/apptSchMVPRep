package app.cal.schedule.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ProductDetails")
@XmlAccessorType(value=XmlAccessType.PROPERTY)
public class ProductDetails extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long productId;
	
	private String productName;
	
	private double unitPrice;
	
	private long capacity;
	

	@XmlElement(name="prodId", required=false)
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	@XmlElement(name="prodName", required=false)
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@XmlElement(name="unitPrice", required=false)
	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@XmlElement(name="capacity", required=false)
	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}
	
	
}
