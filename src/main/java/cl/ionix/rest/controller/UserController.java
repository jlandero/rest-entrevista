package cl.ionix.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.ionix.rest.domain.EndPoint;
import cl.ionix.rest.model.User;
import cl.ionix.rest.service.RestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "user")
@RestController
@RequestMapping(EndPoint.VERSION_1 + "/user")
@Validated
public class UserController {
	
	@Autowired
	private RestService userService;
	
	@ApiOperation(value = "get", notes = "lista usuarios")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 406, message = "Not Acceptable"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping(value = "/listUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> list() {		
	    return userService.allUsers();
	  }
	
	
	@ApiOperation(value = "get", notes = "Busca usuarios dado el email de entrada")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 406, message = "Not Acceptable"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping(value = "/findByEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> email(@PathVariable("email") String email ) {
		
		List<User> usersFind = userService.userByEmail(email);
	    return usersFind;
	  }
	
	@ApiOperation(value = "post", notes = "Guarda nuevo usuario")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 406, message = "Not Acceptable"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public User save(@Valid @RequestBody User user) {
	    return userService.saveUser(user);
	  }

}
