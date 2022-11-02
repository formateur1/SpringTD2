package com.inti.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ProduitSpring")
@Data @NoArgsConstructor @AllArgsConstructor
public class Produit {
	
	@Id
	private int id;
	private String nom;
	private String reference;
	private double prix;
	private double poids;

}
