package app.cal.schedule.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import app.cal.schedule.api.CorpLocDetails;
import app.cal.schedule.api.CorporateDetails;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:Beans.xml")
@WebAppConfiguration
public class CorporateAdminControllerTest {

	@Autowired
	private WebApplicationContext wac;
	private ObjectMapper objMapper;
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc = webAppContextSetup(this.wac).build();
		objMapper = wac.getBean(ObjectMapper.class);
	}
	
	@Test
	public void shouldCreateCorpInfo() throws Exception{

		CorporateDetails corp = new CorporateDetails();
		corp.setCorporateName(" Test CorpLoc2");
		
		CorpLocDetails corpLocation = new CorpLocDetails();
		corpLocation.setStreet("Falls Blvd");
		corpLocation.setCity("Quincy");
		corpLocation.setState("MA");
		corpLocation.setZipCode("02169");
		corpLocation.setCountry("USA");
		corpLocation.setTimezone(TimeZone.getDefault().getDisplayName());
		
		CorpLocDetails corpLocation2 = new CorpLocDetails();
		corpLocation2.setStreet("Southern Artery");
		corpLocation2.setCity("Quincy");
		corpLocation2.setState("MA");
		corpLocation2.setZipCode("02169");
		corpLocation2.setCountry("USA");
		corpLocation2.setTimezone(TimeZone.getDefault().getDisplayName());
		
		List<CorpLocDetails> list = new LinkedList<>();
		list.add(corpLocation);
		list.add(corpLocation2);
		corp.setCorpLocDetails(list);
		System.out.println(objMapper.writeValueAsString(corp));
		RequestBuilder req = post("/corp/admin/setupCorp.json").contentType(MediaType.APPLICATION_JSON).content(objMapper.writeValueAsString(corp));
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();

	}
	
	
	@Test
	public void shouldEditCorpInfo() throws Exception{

		CorporateDetails corp = new CorporateDetails();
		corp.setReferenceId("7E70600CA5D64CE9BA739835A565E37D");
		corp.setCorporateName(" MyTest Corp");
		RequestBuilder req = put("/corp/admin/updateCorp.json").contentType(MediaType.APPLICATION_JSON).content(objMapper.writeValueAsString(corp));
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();

	}
	
	@Test
	public void shouldDeleteCorpInfo() throws Exception{
		
		RequestBuilder req = delete("/corp/admin/delCorp/7E70600CA5D64CE9BA739835A565E37D.json").contentType(MediaType.APPLICATION_JSON);
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
		
	}
	
}
