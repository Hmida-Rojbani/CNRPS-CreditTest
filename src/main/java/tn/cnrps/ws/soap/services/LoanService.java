package tn.cnrps.ws.soap.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.cnrps.ws.soap.loaneligibility.CustomerRequest;
import tn.cnrps.ws.soap.loaneligibility.WsResponse;

@Service
public class LoanService {
	
	public WsResponse checkClient(CustomerRequest customerRequest) {
		
		WsResponse wsResponse = new WsResponse();
		List<String> criteriaMismatch = wsResponse.getCriteriaMismatch();
		
		if(customerRequest.getAge()<30 && customerRequest.getAge() >50)
			criteriaMismatch.add("Age must be between 30 and 50.");
		if(customerRequest.getYearlyIncome() < 12000)
			criteriaMismatch.add("Yearly Income must be over 12000.");
		if(customerRequest.getCibilScore() < 500)
			criteriaMismatch.add("Cibil score must be over 500.");
		
		if(criteriaMismatch.isEmpty()) {
			wsResponse.setIsEligible(true);
			wsResponse.setApprovedAmount((long)(customerRequest.getYearlyIncome()*0.6));
		}else {
			wsResponse.setIsEligible(false);
		}
		
		return null;
	}

}
