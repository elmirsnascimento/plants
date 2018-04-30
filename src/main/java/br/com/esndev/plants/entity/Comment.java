package br.com.esndev.plants.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "COMMENT")
@Data
@NoArgsConstructor
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1609645644716799045L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "TITLE", nullable = false, length = 50)
	private String title;

	@Column(name = "VOTE")
	private int vote;

	@Column(name = "DESCRIPTION", nullable = false, length = 255)
	private String description;

	@ManyToOne
	@JoinColumn(name = "ID_USER")
	private User user;

	@ManyToOne
	@JoinColumn(name = "ID_GROW")
	private Grow grow;

	@ManyToOne
	@JoinColumn(name = "ID_PLANT")
	private Plant plant;

	@ManyToOne
	@JoinColumn(name = "ID_SOIL_MIX")
	private SoilMix soilMix;

}
