package tn.cnrps.ws.soap.endPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import tn.cnrps.ws.soap.loaneligibility.CustomerRequest;
import tn.cnrps.ws.soap.loaneligibility.WsResponse;
import tn.cnrps.ws.soap.services.LoanService;

@Endpoint
public class LoanSoap {
	
	private final static String NAME_SPACE = "http://www.cnrps.tn/ws/soap/loanEligibility";
	
	@Autowired
	private LoanService loanService;
	
	
	@PayloadRoot(namespace = NAME_SPACE,localPart = "CustomerRequest")
	@ResponsePayload
	public WsResponse getStatusClient(@RequestPayload CustomerRequest customerRequest) {
		return loanService.checkClient(customerRequest);
	}
	

}
