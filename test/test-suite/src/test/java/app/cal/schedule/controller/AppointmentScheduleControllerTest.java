package app.cal.schedule.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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

import app.cal.schedule.api.AppointmentScheduleDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:Beans.xml")
@WebAppConfiguration
public class AppointmentScheduleControllerTest {

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
	public void shouldBookAppointment() throws Exception{
		AppointmentScheduleDetails asd = new AppointmentScheduleDetails();
		asd.setTimeSlotId(4);
		asd.setProductId(7);
		asd.setClientId(77);
		asd.setCorpId(1);
		asd.setGroupId(123);
		//asd.setInsertDt(new Date());
		asd.setRecurring(false);
		//asd.setTutSchdId(38);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		
		asd.setStartDt(sdf.parse("2015-04-20"));
		asd.setEndDt(sdf.parse("2015-04-30"));
		asd.setSelectedDays(Arrays.asList(new Long[]{(long) 3}));
		System.out.println(objMapper.writeValueAsString(asd));
		RequestBuilder req = post("/appt/confirm.json").contentType(MediaType.APPLICATION_JSON).content(objMapper.writeValueAsString(asd));
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	
	}
	
	@Test
	public void testfindScheduleStatus() throws Exception{
		RequestBuilder req = get("/appt/status?emailId=gn@gmail.com").contentType(MediaType.APPLICATION_JSON);
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
	
	@Test
	public void testGridViewDataSource() throws Exception{
		RequestBuilder req = get("/appt/view/tslots?status=1&viewType=Grid").contentType(MediaType.APPLICATION_JSON);
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
	
	@Test
	public void testCalViewDataSource() throws Exception{
		RequestBuilder req = get("/appt/view/tslots?status=1&startDt=2015-05-10&endDt=2015-05-17").contentType(MediaType.APPLICATION_JSON);
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
	
	@Test
	public void testCandidateInfo() throws Exception{
		RequestBuilder req = get("/appt/view/info?tutorSchId=208").contentType(MediaType.APPLICATION_JSON);
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
	
}
