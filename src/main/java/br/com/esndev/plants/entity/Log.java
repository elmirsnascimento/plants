package br.com.esndev.plants.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;

import org.springframework.lang.NonNull;

import br.com.esndev.plants.entity.base.BaseEntity;
import br.com.esndev.plants.enumerator.LightType;
import br.com.esndev.plants.enumerator.Stage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LOG", uniqueConstraints = @UniqueConstraint(columnNames = { "ID_PLANT", "LOG_DATE" }))
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@SequenceGenerator(name = "SEQ_LOG", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_LOG")
public class Log extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6864138719762232499L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOG")
	private Long id;

	@Column(name = "DESCRIPTION", nullable = true, length = 500)
	@Max(value=500)
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name = "REGISTRATION_DATE", nullable = false)
	@NonNull
	@PastOrPresent
	private Date registrationDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "LOG_DATE", nullable = false)
	@NonNull
	@PastOrPresent
	private Date logDate;

	@Column(name = "LIGHT_TYPE", nullable = true)
	@Enumerated(EnumType.STRING)
	private LightType lightType;

	@Column(name = "LIGHT_IN_WATTS", nullable = true)
	@Min(value=1)
	@Max(value=2000)
	private Integer lightInWatts;

	@Column(name = "VESSEL_SIZE", nullable = true)
	@Min(value=1)
	@Max(value=500)
	private Integer vesselSize;

	@ManyToOne
	@JoinColumn(name = "ID_SOIL_MIX", nullable = true)
	private SoilMix soilMix;

	@Column(name = "ATTENDED", nullable = false)
	private Boolean attended;

	@Transient
	private Integer wateringFrequency;

	@Transient
	private Float ph;

	@Transient
	private Float ec;

	@OneToOne
	@JoinColumn(name = "ID_WATERING", nullable = true)
	private Watering watering;

	@Column(name = "WATERING_AMOUNT", nullable = true)
	@Min(value=1)
	@Max(value=500)
	private Integer wateringInLiters;

	@Column(name = "STAGE", nullable = false)
	@Enumerated(EnumType.STRING)
	@NonNull
	private Stage stage;

	@Transient
	private Set<Plant> plants;

	@ManyToOne
	@JoinColumn(name = "ID_PLANT", nullable = false)
	@NonNull
	private Plant plant;

}
