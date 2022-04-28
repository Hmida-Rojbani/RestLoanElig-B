package de.tekup.rest.services;

import org.springframework.stereotype.Service;

import de.tekup.rest.models.CustomerRequest;
import de.tekup.rest.models.WsResponse;

@Service
public class LoanService {

	public WsResponse getLoanStatus(CustomerRequest request) {
		WsResponse response = new WsResponse();
		if (request.getAge() < 25 || request.getAge() > 50) {
			response.getCriteriaMismatch().add("Customer age must be between 25 and 50.");
		}
		if (request.getYearlyIncome() < 25000) {
			response.getCriteriaMismatch().add("Customer yearly income must be over 25000.");
		}
		// cibil Score entre 1 -> 999
		if (request.getCibilScore() < 500) {
			response.getCriteriaMismatch().add("Customer cibil score must be over 500.");
		}
		if (response.getCriteriaMismatch().isEmpty()) {
			response.setEligible(true);
			response.setApprovedAmount((long) ((50 - request.getAge()) * request.getYearlyIncome() * 0.4));
		} else {
			response.setEligible(false);
			response.setApprovedAmount(0);
		}
		return response;
	}

}
