package br.com.esndev.plants.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SOIL_MIX")
@Data
@NoArgsConstructor
public class SoilMix implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4330310401884965045L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME", nullable = false, length = 255)
	private String name;

	@ManyToMany(mappedBy = "soilMixes")
	private Set<SoilIngredient> soilIngredients;

	@OneToMany(mappedBy = "soilMix")
	private Set<Log> logs;

	@ManyToOne
	@JoinColumn(name = "ID_USER")
	private User user;

	@OneToMany(mappedBy = "soilMix")
	private Set<Comment> comments;

}
