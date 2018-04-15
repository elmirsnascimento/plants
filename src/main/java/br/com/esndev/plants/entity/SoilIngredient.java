package br.com.esndev.plants.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SOIL_INGREDIENT")
@Data
@NoArgsConstructor
public class SoilIngredient implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1836975409762015978L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "NAME", nullable = false, length = 255)
	private String name;
	
	@ManyToMany
	private Set<SoilMix> soilMixes;
	

}
