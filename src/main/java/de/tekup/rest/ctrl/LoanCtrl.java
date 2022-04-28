package de.tekup.rest.ctrl;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.rest.models.CustomerRequest;
import de.tekup.rest.models.WsResponse;
import de.tekup.rest.services.LoanService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LoanCtrl {
	
	private LoanService service;
	
	@PostMapping(path="/check/client/status",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public WsResponse getStaus(@RequestBody CustomerRequest request) {
		return service.getLoanStatus(request);
	}

}
