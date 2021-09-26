package com.assignment.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.api.util.JwtUtil;

@RestController
@CrossOrigin(originPatterns = "http://*")
public class MainController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/")
	public String welcome() {
		return "Welcome to the app!";
	}

	@PostMapping("/login")
	public ResponseEntity<String> generateToken(@RequestBody AuthRequest authRequest) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (BadCredentialsException e) {
			return new ResponseEntity<String>("Invalid Credentials", HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<String>(jwtUtil.generateToken(authRequest.getUserName()), HttpStatus.OK);
	}
	
	@GetMapping("/data")
	public ResponseEntity<ArrayList<TableRowResponse>> getData() {
		ArrayList<TableRowResponse> data = new ArrayList<TableRowResponse>();
		data.add(new TableRowResponse(913369, "Roshan Bhati", 1, "D1"));
		data.add(new TableRowResponse(913374, "Hritik Sharma", 3, "D2"));
		data.add(new TableRowResponse(913375, "Varun Pandit", 1, "D3"));
		data.add(new TableRowResponse(913371, "Prashant Pathak", 4, "D1"));
		data.add(new TableRowResponse(913370, "Vimal Jha", 4, "D3"));
		data.add(new TableRowResponse(913373, "Sunny Dev", 7, "D2"));
		data.add(new TableRowResponse(913372, "Gopi Chandra", 3, "D4"));
		return new ResponseEntity<ArrayList<TableRowResponse>>(data, HttpStatus.OK);
	}
	
}
