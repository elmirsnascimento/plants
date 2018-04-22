package br.com.esndev.plants.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.esndev.plants.entity.base.BaseEntity;
import br.com.esndev.plants.enumerator.Flowering;
import br.com.esndev.plants.enumerator.Height;
import br.com.esndev.plants.enumerator.RequiredExpertize;
import br.com.esndev.plants.enumerator.Specie;
import br.com.esndev.plants.enumerator.Yield;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "STRAIN")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class Strain extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -118774895698260939L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME", nullable = false, length = 255, unique = true)
	private String name;

	@Column(name = "ESPECIE", nullable = false)
	@Enumerated(EnumType.STRING)
	private Specie specie;

	@Column(name = "REQUIRED_EXPERTIZE", nullable = false)
	@Enumerated(EnumType.STRING)
	private RequiredExpertize requiredExpertize;
	
	@Column(name = "EXPECTED_HEIGHT", nullable = false)
	@Enumerated(EnumType.STRING)
	private Height expectedHeight;
	
	@Column(name = "EXPECTED_YIELD", nullable = false)
	@Enumerated(EnumType.STRING)
	private Yield expectedYield;

	@Column(name = "EXPECTED_FLOWER_WEEKS", nullable = false)
	@Enumerated(EnumType.STRING)
	private Flowering expectedFlowerWeeks;
	
	@OneToMany(mappedBy = "strain")
	private Set<Plant> plants;

}
