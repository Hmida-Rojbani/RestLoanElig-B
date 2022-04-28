package de.tekup.rest.ctrl;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.rest.models.CustomerRequest;
import de.tekup.rest.models.WsResponse;
import de.tekup.rest.services.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LoanCtrl {
	
	private LoanService service;
	
	@Operation(summary = "checking client status",operationId = "Check Client",
			responses = {
					@ApiResponse(responseCode = "200", description = "Return Client Status"),
					@ApiResponse(responseCode = "400", description = "Not yet implimented")
			})
	@PostMapping(path="/check/client/status",
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public WsResponse getStatus(@RequestBody CustomerRequest request) {
		return service.getLoanStatus(request);
	}

}
