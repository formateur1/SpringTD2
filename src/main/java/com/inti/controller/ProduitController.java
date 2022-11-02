package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.repository.IProduitRepository;

@RestController
@RequestMapping("produit")
public class ProduitController {
	
	@Autowired
	IProduitRepository ipr;
	
	

}
