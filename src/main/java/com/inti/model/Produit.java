package com.inti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "produit_magasin",
				joinColumns = @JoinColumn(name = "idProduit"),
				inverseJoinColumns = @JoinColumn(name = "idMagasin"))
	private List<Magasin> listeMagasin;

}
