package br.com.esndev.plants.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.esndev.plants.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "WATERING")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@SequenceGenerator(name = "SEQ_WATERING", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_WATERING")
public class Watering extends BaseEntity implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 2059530725228448651L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_WATERING")
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "REGISTRATION_DATE", nullable = false)
	private Date registrationDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "WATERING_DATE", nullable = false)
	private Date wateringDate;

	@Column(name = "SKIP", nullable = false)
	private boolean skip;

	@Column(name = "PH", nullable = false)
	private float ph;

	@Column(name = "EC", nullable = false)
	private float ec;

	@OneToOne(mappedBy = "watering")
	private Log log;

	@ManyToMany
	private Set<Fertilizer> fertilizers;

}
