package app.cal.schedule.api;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="ClientGroupDetails")
@XmlAccessorType(value=XmlAccessType.PROPERTY)
public class ClientGroupDetails extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@XmlElement(name="groupId")
	private String groupId;

	@XmlElement(name="primEmail")
	private String primParentEmailId;

	@XmlElement(name="secEmail")
	private String secParentEmailId;

	@XmlElement(name="primCntNo")
	private String primContactNo;

	@XmlElement(name="secCntNo")
	private String secContactNo;

	@XmlElement(name="list")
	private List<ClientInfoDetails> list = new LinkedList<>();
	
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getPrimParentEmailId() {
		return primParentEmailId;
	}

	public void setPrimParentEmailId(String primParentEmailId) {
		this.primParentEmailId = primParentEmailId;
	}

	public String getSecParentEmailId() {
		return secParentEmailId;
	}

	public void setSecParentEmailId(String secParentEmailId) {
		this.secParentEmailId = secParentEmailId;
	}

	public String getPrimContactNo() {
		return primContactNo;
	}

	public void setPrimContactNo(String primContactNo) {
		this.primContactNo = primContactNo;
	}

	public String getSecContactNo() {
		return secContactNo;
	}

	public void setSecContactNo(String secContactNo) {
		this.secContactNo = secContactNo;
	}

	public List<ClientInfoDetails> getList() {
		return list;
	}

	public void setList(List<ClientInfoDetails> list) {
		this.list = list;
	}
		
}
