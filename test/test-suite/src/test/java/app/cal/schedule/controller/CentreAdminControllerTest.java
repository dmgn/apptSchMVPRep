package app.cal.schedule.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
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

import app.cal.schedule.api.ClientEnrollmentDetails;
import app.cal.schedule.api.ClientGroupDetails;
import app.cal.schedule.api.ClientInfoDetails;
import app.cal.schedule.api.ClientSvcPkgInfoDetails;
import app.cal.schedule.api.LocationWrkHrsDtls;
import app.cal.schedule.api.PackageDetails;
import app.cal.schedule.api.ProductDetails;
import app.cal.schedule.api.TimeSlotDetails;
import app.cal.schedule.api.TutorDetails;
import app.cal.schedule.api.TutorScheduleDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:Beans.xml")
@WebAppConfiguration
public class CentreAdminControllerTest {

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
	public void shouldCreateProduct() throws Exception{
		ProductDetails prod = new ProductDetails();
		prod.setProductName("Prod1");
		prod.setUnitPrice(10.00);
		prod.setCorpId(1);
		prod.setCapacity(4);
		RequestBuilder req = post("/centre/admin/addProd.json").contentType(MediaType.APPLICATION_JSON).content(objMapper.writeValueAsString(prod));
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
	
	@Test
	public void shouldDeleteProductByRefId() throws Exception {
		
		RequestBuilder req = delete("/centre/admin/delProd/F53B7D7D56E74EE597AD188C033DEB8D.json").contentType(MediaType.APPLICATION_JSON);
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
	
	@Test
	public void shouldEditProduct() throws Exception{
		ProductDetails prod = new ProductDetails();
		prod.setProductName("ProdEdit1");
		prod.setUnitPrice(10.00);
		prod.setReferenceId("E897E4157CE545B683FE964F54A02ACC");
		RequestBuilder req = put("/centre/admin/updateProd.json").contentType(MediaType.APPLICATION_JSON).content(objMapper.writeValueAsString(prod));
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
		
	}
	
	@Test
	public void shouldReturnProductList() throws Exception{
	
		RequestBuilder req = get("/centre/admin/1.json").contentType(MediaType.APPLICATION_JSON);
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();

	}
	
	@Test
	public void shouldCreatePackage() throws Exception{
		PackageDetails pkg = new PackageDetails();
		pkg.setPackageName("P1");
		pkg.setPackageDuration(6);
		RequestBuilder req = post("/centre/admin/addPkg.json").contentType(MediaType.APPLICATION_JSON).content(objMapper.writeValueAsString(pkg));
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
	
	@Test
	public void shouldEditPkg() throws Exception{
		PackageDetails pkg = new PackageDetails();
		pkg.setPackageName("P1");
		pkg.setPackageDuration(2);
		pkg.setPackageDesc("Test desc");
		pkg.setPackageOfferCode("offer");
		pkg.setVersion(2);
		pkg.setReferenceId("556DF4E350AB46B6A10D4D74B11B0209");
		RequestBuilder req = put("/centre/admin/updatePkg.json").contentType(MediaType.APPLICATION_JSON).content(objMapper.writeValueAsString(pkg));
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
		
	}
	
	@Test
	public void shouldDeletePackageByRefId() throws Exception {
		
		RequestBuilder req = delete("/centre/admin/delPkg/A1F95D57FBC0475EAFD1950693B2F242.json").contentType(MediaType.APPLICATION_JSON);
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
	
	
	@Test
	public void shouldCreateTutor() throws Exception{
		TutorDetails tut = new TutorDetails();
		tut.setTutorName("TestTutor2");
		tut.setCorpId(1);
		List<Long> list = new LinkedList<>();
		list.add((long) 3);
		list.add((long) 2);
		list.add((long) 4);
		tut.setProductIds(list);
		System.out.println(" *********** " + objMapper.writeValueAsString(tut));
		RequestBuilder req = post("/centre/admin/addTutor.json").contentType(MediaType.APPLICATION_JSON).content(objMapper.writeValueAsString(tut));
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
	
	@Test
	public void shouldEditTutor() throws Exception{
		TutorDetails tut = new TutorDetails();
		tut.setTutorName("GautamN");
		tut.setReferenceId("79B2F1CDBB98468389F9D49B361D1EDB");
		RequestBuilder req = put("/centre/admin/updateTutor.json").contentType(MediaType.APPLICATION_JSON).content(objMapper.writeValueAsString(tut));
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
		
	}
	
	@Test
	public void searchTutorList() throws Exception{
		RequestBuilder req = get("/centre/admin/tutor.json?corpId=1").contentType(MediaType.APPLICATION_JSON);
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}

	@Test
	public void searchLocations() throws Exception{
		RequestBuilder req = get("/centre/admin/loc.json?corpId=1").contentType(MediaType.APPLICATION_JSON);
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
	
	@Test
	public void searchTimeSlots() throws Exception{
		RequestBuilder req = get("/centre/admin/timeSlots.json?startDt=2015-04-11&endDt=2015-04-12&prodId=1&locId=1&timeSlotId=1")
				.contentType(MediaType.APPLICATION_JSON).characterEncoding("iso-8859");
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
	
	@Test
	public void searchOneTutor() throws Exception{
		RequestBuilder req = get("/centre/admin/tutor/79B2F1CDBB98468389F9D49B361D1EDB.json").contentType(MediaType.APPLICATION_JSON);
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}

	@Test
	public void shouldDeleteTutor() throws Exception{
		RequestBuilder req = delete("/centre/admin/delTutor/79B2F1CDBB98468389F9D49B361D1EDB.json").contentType(MediaType.APPLICATION_JSON);
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
	
	@Test
	public void shouldCreateClientInfo() throws Exception{
		ClientInfoDetails cid1 = new ClientInfoDetails();
		cid1.setCorpId(1);
		cid1.setDob(new Date(System.currentTimeMillis()));
		cid1.setEmailId("gautam.naik@gmail.com");
		cid1.setFirstName("Gautam");
		cid1.setLastName("Naik");
		cid1.setRequestId("Req1");
		
		ClientInfoDetails cid2 = new ClientInfoDetails();
		cid2.setCorpId(1);
		cid2.setDob(new Date(System.currentTimeMillis()));
		cid2.setEmailId("gautam2.naik2@gmail.com");
		cid2.setFirstName("Gautam2");
		cid2.setLastName("Naik2");
		cid2.setRequestId("Req1");

		
		List<ClientInfoDetails> list = new LinkedList<>();
		list.add(cid1);
		list.add(cid2);
		ClientGroupDetails cg1 = new ClientGroupDetails();
		cg1.setList(list);
		cg1.setCorpId(1);
		cg1.setPrimContactNo("0000000000");
		cg1.setSecContactNo("1111111111");
		cg1.setPrimParentEmailId("gn@yahoo.com");
		cg1.setSecParentEmailId("gn2@yahoo.com");
		cg1.setRequestId("Req1");

		System.out.println(objMapper.writeValueAsString(cg1));
		
		RequestBuilder req = post("/centre/admin/addClient.json").contentType(MediaType.APPLICATION_JSON).content(objMapper.writeValueAsString(cg1));
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
	
	
	@Test
	public void testfindAllClientInfo() throws Exception{
		RequestBuilder req = get("/centre/admin/clientList?corpId=1").contentType(MediaType.APPLICATION_JSON);
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
	
	@Test
	public void testfindOneClientInfo() throws Exception{
		RequestBuilder req = get("/centre/admin/client/B6A61A4616624CDCA4579E15899CF1A2.json").contentType(MediaType.APPLICATION_JSON);
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
	
	@Test
	public void shouldCreateClientEnrollment() throws Exception{
	
		ClientEnrollmentDetails ceDtls = new ClientEnrollmentDetails();
		ceDtls.setProductId(1);
		ceDtls.setClientId(1);
		ceDtls.setEnrolledDate(new Date(System.currentTimeMillis()));
		RequestBuilder req = post("/centre/admin/enroll.json").contentType(MediaType.APPLICATION_JSON).content(objMapper.writeValueAsString(ceDtls));
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
		

	@Test
	public void shouldCreateLocWrkHrs() throws Exception{
		LocationWrkHrsDtls lwhd = new LocationWrkHrsDtls();
		lwhd.setStartTime("6 PM");
		lwhd.setEndTime("7 PM");
		lwhd.setLocationId(3);
		
		System.out.println(objMapper.writeValueAsString(lwhd));
		RequestBuilder req = post("/centre/admin/loc/wrkHrs.json").contentType(MediaType.APPLICATION_JSON).content(objMapper.writeValueAsString(lwhd));
		System.out.println(objMapper.writeValueAsString(lwhd));
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
	
	@Test
	public void shouldCreateTutorSchedule() throws Exception{
		TutorScheduleDetails tsDtls = new TutorScheduleDetails();
		
		tsDtls.setProdIds(Arrays.asList(Long.valueOf(1), Long.valueOf(2)));
		List<Long> tsdList = new LinkedList<>();
		tsdList.add((long) 1);
		tsdList.add((long) 2);
		//tsDtls.setTimeSlotDtls(tsdList);
		tsDtls.setTutorId(2);
		tsDtls.setStartDate(new Date(System.currentTimeMillis()));
		tsDtls.setEndDate(new Date(System.currentTimeMillis() + (72*1000 * 60 * 60)));
		tsDtls.setTimeSlotIds(tsdList);
		tsDtls.setProdIds(Arrays.asList(Long.valueOf(1), Long.valueOf(2)));
		RequestBuilder req = post("/centre/admin/tutorSchedule.json").contentType(MediaType.APPLICATION_JSON).content(objMapper.writeValueAsString(tsDtls));
		
		System.out.println(objMapper.writeValueAsString(tsDtls));
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}	
	
	@Test
	public void shouldListTutorSchedule() throws Exception{

		RequestBuilder req = get("/centre/admin/tutorSchedule?tutorId=1").contentType(MediaType.APPLICATION_JSON);
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
	/*@Test
	public void shouldDeleteTutorSchedule() throws Exception{
		RequestBuilder req = put("/centre/admin/tutorSchedule.json").contentType(MediaType.APPLICATION_JSON).content(objMapper.writeValueAsString(tsDtls));
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}*/
	
	@Test
	public void shouldCreateClientSvcPkg() throws Exception{
		ClientSvcPkgInfoDetails cspiDtls = new ClientSvcPkgInfoDetails();
		cspiDtls.setCorpId(1);
		cspiDtls.setEnrollId(1);
		cspiDtls.setInsertDate(new Date());
		cspiDtls.setPkgStartDate(new Date());
		cspiDtls.setPkgEndDate(new Date());
		cspiDtls.setProductId(1);
		cspiDtls.setPackageId(1);
		RequestBuilder req = post("/centre/admin/clientSvcPkg.json").contentType(MediaType.APPLICATION_JSON)
				.content(objMapper.writeValueAsString(cspiDtls));
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
		
	}
	
	@Test
	public void shouldEditClientSvcPkg() throws Exception{
		ClientSvcPkgInfoDetails cspiDtls = new ClientSvcPkgInfoDetails();
		cspiDtls.setCorpId(1);
		cspiDtls.setEnrollId(1);
		cspiDtls.setInsertDate(new Date());
		cspiDtls.setPkgStartDate(new Date());
		cspiDtls.setPkgEndDate(new Date());
		cspiDtls.setProductId(5);
		cspiDtls.setPackageId(1);
		cspiDtls.setReferenceId("C903CF63E6A743DB94EE152E748E4C4D");
		RequestBuilder req = put("/centre/admin/clientSvcPkg.json").contentType(MediaType.APPLICATION_JSON)
				.content(objMapper.writeValueAsString(cspiDtls));
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
		
	}
	
	@Test
	public void shouldListOnePackage() throws Exception{
		RequestBuilder req = get("/centre/admin/clientSvcPkg?corpId=1&prodId=1&clientId=56").contentType(MediaType.APPLICATION_JSON);
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
	
	@Test
	public void shouldDeleteClientSvcPkg() throws Exception{

		RequestBuilder req = delete("/centre/admin/clientSvcPkg/C903CF63E6A743DB94EE152E748E4C4D.json").contentType(MediaType.APPLICATION_JSON);
				
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
		
	}
	
	@Test
	public void shouldListAllPackages() throws Exception{
		RequestBuilder req = get("/centre/admin/package/1.json").contentType(MediaType.APPLICATION_JSON);
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
	
	@Test
	public void shouldListAllLocationWrkHoursByCorp() throws Exception{
		RequestBuilder req = get("/centre/admin/wrkHrs/1").contentType(MediaType.APPLICATION_JSON);
		MvcResult res = mockMvc.perform(req).andDo(print()).andReturn();
	}
}
