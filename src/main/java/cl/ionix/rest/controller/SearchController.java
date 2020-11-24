package cl.ionix.rest.controller;

import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.ionix.rest.domain.EndPoint;
import cl.ionix.rest.service.RestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "search")
@RestController
@RequestMapping(EndPoint.VERSION_1 + "/search")
public class SearchController {
	
	@Autowired
	private RestService userService; 
	
	@ApiOperation(value = "call api", notes = "Llamada api test-tecnico")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 406, message = "Not Acceptable"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping(value = "/call/{rut}", produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<String> call( @PathVariable("rut") String rut) throws GeneralSecurityException {		
		return new ResponseEntity<>(userService.callExternalApi(rut), HttpStatus.OK);
	  }

}
