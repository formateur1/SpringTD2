package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Magasin;
import com.inti.repository.IMagasinRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("magasin")
@Slf4j
public class MagasinController {
	
	@Autowired
	IMagasinRepository imr;
	
	@GetMapping("magasins")
	public List<Magasin> getMagasins()
	{
		log.info("Liste de tous les magasins");
		return imr.findAll();
	}
	
	@PostMapping("save")
	public boolean saveMagasin(@RequestBody Magasin magasin)
	{
		if(magasin != null)
		{
			log.info("L'objet magasin " + magasin + " a pu etre enregistré en BDD.");
			imr.save(magasin);
			return true;
		}
		log.error("L'objet magasin " + magasin + " n'a pas pu etre enregistré en BDD !");
		return false;
	}
	
	@DeleteMapping("delete/{id}")
	public boolean deleteMagasin(@PathVariable int id)
	{
		if(id > 0)
		{
			log.info("Delete de l'objet magasin, id : " + id);
			imr.deleteById(id);
			return true;
		}
		
		log.error("L'objet magasin, id : " + id + " n'a pas pu être supprimé de la BDD !");
		return false;
	}
	
	@GetMapping("magasin/{id}")
	public Magasin getMagasin(@PathVariable int id)
	{
		try {
			log.info("Magasin, id : " + id + " récupéré");
			return imr.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("L'id : " + id + " n'existe pas en BDD !");
		}
		
		return null;
	}
	
	@PutMapping("update/{id}")
	public Magasin updateMagasin(@RequestBody Magasin nouveauMagasin, @PathVariable int id)
	{
		return imr.findById(id)
				.map(magasin -> {
					magasin.setNom(nouveauMagasin.getNom());
					magasin.setAdresse(nouveauMagasin.getAdresse());
					magasin.setCp(nouveauMagasin.getCp());
					magasin.setVille(nouveauMagasin.getVille());
					return imr.save(magasin);
				})
				.orElseGet(() -> {
					return imr.save(nouveauMagasin);
				});		
	}

}
