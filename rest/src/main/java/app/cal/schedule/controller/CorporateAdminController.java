package app.cal.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.CorporateDetails;
import app.cal.schedule.business.corporate.CorporateInfoService;


@Controller
@RequestMapping(value="/corp/admin")
public class CorporateAdminController {

	@Autowired
	private CorporateInfoService corporateInfoService;
	
	
	@RequestMapping(method=RequestMethod.POST, value="/setupCorp")
	public ResponseEntity<BaseMessage> setupCorpInfo( @RequestBody CorporateDetails corpDetails ){
		return new ResponseEntity<BaseMessage>( corporateInfoService.setUpCorpInfo( corpDetails ), HttpStatus.OK );
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/delCorp/{refId}")
	public ResponseEntity<BaseMessage> deleteCorpInfo( @PathVariable String refId ){
		return new ResponseEntity<BaseMessage>( corporateInfoService.deleteCorpInfo(refId), HttpStatus.OK );
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateCorp")
	public ResponseEntity<BaseMessage> updateCorpInfo( @RequestBody CorporateDetails corpDetails ){
		return new ResponseEntity<BaseMessage>( corporateInfoService.updateCorpInfo( corpDetails ), HttpStatus.OK );
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/setupCorp/loc")
	public ResponseEntity<Object> setupCorpLocationInfo(){
		
		return null;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/appts/daily")
	public ResponseEntity<Object> fetchDailyApptsByLocation(){
		
		return null;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/appts/weekly")
	public ResponseEntity<Object> fetchWeeklyApptsByLocation(){
		
		return null;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/download")
	public byte[] downloadReports( String reportName ){
		
		return null;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/saveToFile")
	public void exportSummary( String reportName ){
		
		//return null;
	}
}
