package br.com.esndev.plants.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LANGUAGE")
@Data
@NoArgsConstructor
//TODO Ainda desvinculada
public class Language implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2236738011114818131L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "INITIALS", nullable = false, length = 3)
	private String initials;

	@Column(name = "NAME", nullable = false, length = 50)
	private String name;

}
