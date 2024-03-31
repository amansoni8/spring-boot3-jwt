package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.AuthRequest;
import com.example.dto.Product;
import com.example.entity.UserInfo;
import com.example.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductConroller {

	@Autowired
	private ProductService service;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/welcome")
	public String welcome() {
		return  "welcome this endpoint is  not secure";
	}
	
	@GetMapping("/new")
	public String addNewUser(@RequestBody UserInfo userInfo) {
		return service.addUser(userInfo);
	}
	
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Product> getAllProducts(){
		return service.getProducts();
	}
	
	 @GetMapping("/{id}")
	 @PreAuthorize("hasAuthority('ROLE_USER')")
	 public Product getProductById(@PathVariable int id) {
	    return service.getProduct(id);
	    }
	 
	 @PostMapping("/authenticate")
	 public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		 Authentication authentication = authenticationManager.authenticate((new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()))
				 
				 if (authentication.isAuthenticated()) {
			            return jwtService.generateToken(authRequest.getUsername());
			        } else {
			            throw new UsernameNotFoundException("invalid user request !");
			        }
	 }

}
