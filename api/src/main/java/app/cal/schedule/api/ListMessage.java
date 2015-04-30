package app.cal.schedule.api;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="list")
@XmlAccessorType(value=XmlAccessType.PROPERTY)
public class ListMessage<T extends BaseMessage> extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<T> list;
	
	private Integer count;
	
	private String Result = "OK";
			

	public ListMessage(){}
	
	public ListMessage(List<T> list){
		this.list = list;
	}

	@XmlAnyElement(lax = true)
	@XmlElement(name="Records")
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@XmlElement(name="TotalRecordCount")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@XmlElement(name="Result")
	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}
	
	
	
}
