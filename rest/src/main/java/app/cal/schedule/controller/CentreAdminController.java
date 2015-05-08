package app.cal.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ClientEnrollmentDetails;
import app.cal.schedule.api.ClientGroupDetails;
import app.cal.schedule.api.ClientSvcPkgInfoDetails;
import app.cal.schedule.api.LocationWrkHrsDtls;
import app.cal.schedule.api.PackageDetails;
import app.cal.schedule.api.ProductDetails;
import app.cal.schedule.api.TutorDetails;
import app.cal.schedule.api.TutorScheduleDetails;
import app.cal.schedule.business.centre.AppointmentScheduleService;
import app.cal.schedule.business.centre.ClientEnrollmentService;
import app.cal.schedule.business.centre.ClientInfoService;
import app.cal.schedule.business.centre.ClientSvcPkg;
import app.cal.schedule.business.centre.LocationWorkHours;
import app.cal.schedule.business.centre.PackageService;
import app.cal.schedule.business.centre.ProductService;
import app.cal.schedule.business.centre.TutorService;


@Controller
@RequestMapping(value="/centre/admin")
public class CentreAdminController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PackageService packageService;
	
	@Autowired
	private TutorService tutorService;
	
	@Autowired
	private ClientInfoService clientInfoService;
	
	@Autowired
	private ClientEnrollmentService clientEnrollmentService;
	
	@Autowired
	private LocationWorkHours locationWorkHours;

	@Autowired
	private ClientSvcPkg clientSvcPkg;
	
	@Autowired
	private AppointmentScheduleService appointmentScheduleService;
	
	@RequestMapping(method=RequestMethod.POST, value="/addProd")
	public ResponseEntity<BaseMessage> addProduct( @RequestBody ProductDetails prodDtls ){		
		return new ResponseEntity<BaseMessage>(productService.addProduct( prodDtls ), HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/delProd/{refId}")
	public ResponseEntity<BaseMessage> deleteProduct(@PathVariable String refId){
		return new ResponseEntity<BaseMessage>(productService.deleteProductByRefId(refId), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateProd")
	public ResponseEntity<BaseMessage> updateProduct( @RequestBody ProductDetails prodDtls ){
		return new ResponseEntity<BaseMessage>(productService.updateProduct( prodDtls ), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/products/{corpId}")
	public ResponseEntity<BaseMessage> findAllProducts( @PathVariable long corpId ){
		return new ResponseEntity<BaseMessage>(productService.findAllProducts(corpId), HttpStatus.OK);
	}	
	
	@RequestMapping(method=RequestMethod.GET, value="/products/tutor/{tutorId}")
	public ResponseEntity<BaseMessage> findProductsByTutorId( @PathVariable long tutorId ){
		return new ResponseEntity<BaseMessage>(productService.findProductsByTutorId(tutorId), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/products/client/{clientId}")
	public ResponseEntity<BaseMessage> findProductsByClientId( @PathVariable long clientId ){
		return new ResponseEntity<BaseMessage>(productService.findProductsByClientId(clientId), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addPkg")
	public ResponseEntity<BaseMessage> addPackage( @RequestBody PackageDetails pkgDtls ){
		return new ResponseEntity<BaseMessage>( packageService.addPackage(pkgDtls), HttpStatus.OK );
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/delPkg/{refId}")
	public ResponseEntity<BaseMessage> deletePackage(@PathVariable String refId){
		return new ResponseEntity<BaseMessage>( packageService.deletePackageByRefId(refId), HttpStatus.OK );
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updatePkg")
	public ResponseEntity<BaseMessage> updatePackage(  @RequestBody PackageDetails pkgDtls  ){
		return new ResponseEntity<BaseMessage>( packageService.updatePackage(pkgDtls), HttpStatus.OK );
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/package/{corpId}")
	public ResponseEntity<BaseMessage> findAllPackages( @PathVariable long corpId ){
		return new ResponseEntity<BaseMessage>(packageService.listPackages(corpId), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/tutor")
	public ResponseEntity<BaseMessage> findAllTutors( @RequestParam(value="corpId", required=true) long corpId ){
		return new ResponseEntity<BaseMessage>(tutorService.findAllTutorsFor(corpId), HttpStatus.OK);
	}	
	
	@RequestMapping(method=RequestMethod.GET, value="/tutor/{refId}")
	public ResponseEntity<BaseMessage> findOneTutor( @PathVariable String refId ){
		return new ResponseEntity<BaseMessage>(tutorService.findTutorByRefId(refId), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addTutor")
	public ResponseEntity<BaseMessage> addTutor( @RequestBody TutorDetails tutDtls ){
		return new ResponseEntity<BaseMessage>( tutorService.addTutor(tutDtls), HttpStatus.OK );
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/delTutor/{refId}")
	public ResponseEntity<BaseMessage> deleteTutor(@PathVariable String refId){
		return new ResponseEntity<BaseMessage>( tutorService.deleteTutorByRefId(refId), HttpStatus.OK );
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateTutor")
	public ResponseEntity<BaseMessage> updateTutorInfo(  @RequestBody TutorDetails tutorDtls  ){
		return new ResponseEntity<BaseMessage>( tutorService.updateTutor(tutorDtls) , HttpStatus.OK );
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addClient")
	public ResponseEntity<BaseMessage> addTutor( @RequestBody ClientGroupDetails cgrpDtls ){
		return new ResponseEntity<BaseMessage>( clientInfoService.addClientInfo(cgrpDtls), HttpStatus.OK );
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/clientList")
	public ResponseEntity<BaseMessage> findAllClientsFor( @RequestParam(value="corpId", required=true) long corpId ){
		return new ResponseEntity<BaseMessage>(clientInfoService.findAllClientsFor(corpId), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/client/{refId}")
	public ResponseEntity<BaseMessage> findAllClientsFor(@PathVariable String refId){
		return new ResponseEntity<BaseMessage>(clientInfoService.findClientInfo(refId), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/client")
	public ResponseEntity<BaseMessage> findClientByEmail( @RequestParam(value="emailId", required=true) String emailId ){
		return new ResponseEntity<BaseMessage>(clientInfoService.findClientByEmailId(emailId), HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/enrollClient")
	public ResponseEntity<BaseMessage> enrollClient( @RequestBody ClientEnrollmentDetails clntEnrollmentDtls, ModelMap map ){
		return new ResponseEntity<BaseMessage>( clientEnrollmentService.addClientEnrollmentInfo(clntEnrollmentDtls), HttpStatus.OK );
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/enroll/id/{refId}")
	public ResponseEntity<BaseMessage> findEnrollment(@PathVariable String refId){
		return new ResponseEntity<BaseMessage>( clientEnrollmentService.findClientEnrollment(refId), HttpStatus.OK );
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/wrkHrs/{corpId}")
	public ResponseEntity<BaseMessage> findWorkHoursForCorp(@PathVariable long corpId){
		return new ResponseEntity<BaseMessage>( locationWorkHours.findLocWorkHourDtlsByCorpId(corpId), HttpStatus.OK );
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/wrkHrs/loc")
	public ResponseEntity<BaseMessage> findWorkHoursForLoc(@RequestParam(value="corpId", required=true) long corpId,
			@RequestParam(value="locId", required=true) long locId){
		return new ResponseEntity<BaseMessage>( locationWorkHours.findLocWorkHourDtlsByLocId(corpId, locId), HttpStatus.OK );
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/loc")
	public ResponseEntity<BaseMessage> findWorkHoursForLoc(@RequestParam(value="corpId", required=true) long corpId){
		return new ResponseEntity<BaseMessage>( locationWorkHours.findLocationByCorpId(corpId), HttpStatus.OK );
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/loc/wrkHrs")
	public ResponseEntity<BaseMessage> setupLocWorkHours( @RequestBody LocationWrkHrsDtls locWrkHrsDtls ){
		return new ResponseEntity<BaseMessage>( locationWorkHours.addLocWrkHours(locWrkHrsDtls), HttpStatus.OK );
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/tutorSchedule")
	public ResponseEntity<BaseMessage> setupTutorSchedule( @RequestBody TutorScheduleDetails tutorScheduleDtls ){
		return new ResponseEntity<BaseMessage>( tutorService.createTutorSchedule(tutorScheduleDtls), HttpStatus.OK );
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/tutorSchedule")
	public ResponseEntity<BaseMessage> updateTutorSchedule( @RequestBody TutorScheduleDetails tutorScheduleDtls ){
		return new ResponseEntity<BaseMessage>( tutorService.updateTutorSchedule(tutorScheduleDtls), HttpStatus.OK );
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/tutorSchedule/{refId}")
	public ResponseEntity<BaseMessage> deleteTutorSchedule(@PathVariable String refId){
		return new ResponseEntity<BaseMessage>( tutorService.deleteTutorScheduleByRefId(refId), HttpStatus.OK );
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/tutorSchedule")
	public ResponseEntity<BaseMessage> findTutorSchedule(@RequestParam(value="tutorId", required=true) long tutorId
//			@RequestParam(value="prodId", required=false) long productId,
//			@RequestParam(value="locId", required=false) long locId
			){
		return new ResponseEntity<BaseMessage>( tutorService.findTutorSchedule(tutorId, 0, 0) , HttpStatus.OK );
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/clientSvcPkg")
	public ResponseEntity<BaseMessage> findClientSvcPkg(@RequestParam(value="corpId", required=true) long corpId,
			@RequestParam(value="prodId", required=false) long prodId,
			@RequestParam(value="clientId", required=false) long clientId){
		return new ResponseEntity<BaseMessage>( clientSvcPkg.findPkgDtlsForProductByClientId(corpId, prodId, clientId) , HttpStatus.OK );
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/clientSvcPkg")
	public ResponseEntity<BaseMessage> addClientSvcPkg( @RequestBody ClientSvcPkgInfoDetails clientSvcPkgInfoDetails ){
		return new ResponseEntity<BaseMessage>( clientSvcPkg.addClientSvcPkg(clientSvcPkgInfoDetails), HttpStatus.OK );
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/clientSvcPkg")
	public ResponseEntity<BaseMessage> updateClientSvcPkg( @RequestBody ClientSvcPkgInfoDetails clientSvcPkgInfoDetails ){
		return new ResponseEntity<BaseMessage>( clientSvcPkg.updateClientSvcPkg(clientSvcPkgInfoDetails), HttpStatus.OK );
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/clientSvcPkg/{refId}")
	public ResponseEntity<BaseMessage> deleteClientSvcPkg(@PathVariable String refId){
		return new ResponseEntity<BaseMessage>( clientSvcPkg.deleteCSPIDtlsByRefId(refId), HttpStatus.OK );
	}
	
/*	@RequestMapping(method=RequestMethod.GET, value="/timeSlots")
	public ResponseEntity<BaseMessage> search(@RequestParam(value="startDt", required=true) String startDt,
			@RequestParam(value="endDt", required=true) String endDt,
			@RequestParam(value="prodId", required=true) long prodId,
			@RequestParam(value="locId", required=false) long locId,
			@RequestParam(value="timeSlotId", required=false) long timeSlotId) throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = sdf.parse(startDt);
		Date endDate = sdf.parse(endDt);		
		return new ResponseEntity<BaseMessage>( appointmentScheduleService.search(prodId, startDate, endDate, locId, timeSlotId) , HttpStatus.OK );
	}
	*/
}
