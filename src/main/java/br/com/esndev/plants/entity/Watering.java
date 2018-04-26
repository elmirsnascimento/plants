package br.com.esndev.plants.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.esndev.plants.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FERTILIZATION")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class Watering extends BaseEntity implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 2059530725228448651L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "REGISTRATION_DATE", nullable = false)
	private Date registrationDate;

	@Column(name = "SKIP", nullable = false)
	private boolean skip;

	@Column(name = "EXPECTED_PH", nullable = false)
	private float expectedPH;

	@Column(name = "EXPECTED_EC", nullable = false)
	private float expectedEC;

	@ManyToOne
	@JoinColumn(name = "ID_PLANT", nullable = false)
	private Plant plant;

	@ManyToMany
	private Set<Fertilizer> fertilizers;

}
