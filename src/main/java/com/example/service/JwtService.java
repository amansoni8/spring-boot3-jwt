package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.Product;
import com.example.repository.UserInfoRepository;

import jakarta.annotation.PostConstruct;

@Service
public class JwtService {

	 List<Product> productList = null;

	    @Autowired
	    private UserInfoRepository repository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;
	    
	    @PostConstruct
	    public void loadProductsFromDB() {
	        productList = IntStream.rangeClosed(1, 100)
	                .mapToObj(i -> Product.builder()
	                        .productId(i)
	                        .name("product " + i)
	                        .qty(new Random().nextInt(10))
	                        .price(new Random().nextInt(5000)).build()
	                ).collect(Collectors.toList());
	    }

}
