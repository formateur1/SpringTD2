package com.inti.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Produit;
import com.inti.repository.IProduitRepository;


@RestController
@RequestMapping("produit")
public class ProduitController {
	
	@Autowired
	IProduitRepository ipr;
	
	@GetMapping("produits")
	public List<Produit> getProduits()
	{
		return ipr.findAll();
	}
	
	@PostMapping("saveProduit")
	public boolean saveProduit(@RequestBody Produit produit)
	{
		if(produit != null)
		{
			ipr.save(produit);
			return true;
		}
		
		return false;
	}
	
	@GetMapping("produit/{id}")
	public Produit getProduit(@PathVariable int id)
	{
		Produit p;
		try {
			p = ipr.findById(id).get();
		}
		catch (Exception e) {
			e.printStackTrace();
			p = null;
		}
		return p;
	}
	
	@DeleteMapping("deleteProduit/{id}")
	public boolean deleteProduit(@PathVariable int id)
	{
		if(id > 0)
		{
			ipr.deleteById(id);
			return true;
		}
		
		return false;
	}

}
