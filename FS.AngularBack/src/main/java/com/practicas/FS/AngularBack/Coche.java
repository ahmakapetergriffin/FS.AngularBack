package com.practicas.FS.AngularBack;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table (name = "coche")
public class Coche {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Long id;

	  private String marca;

	  private String modelo;
	  
	

}









