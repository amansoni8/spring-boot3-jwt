package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.Product;
import com.example.repository.UserInfoRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProductService {
	
	List<Product> productList = null;
	
    @Autowired
    private UserInfoRepository repository;

//    @Autowired
//    private final PasswordEncoder passwordEncoder;
    
    @PostConstruct
    public void loadProductsFromDB() {
    	
    	}
}
