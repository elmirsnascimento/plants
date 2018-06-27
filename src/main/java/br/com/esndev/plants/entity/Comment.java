package br.com.esndev.plants.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import br.com.esndev.plants.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "COMMENT")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@SequenceGenerator(name = "SEQ_COMMENT", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_COMMENT")
public class Comment extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1609645644716799045L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMMENT")
	private Long id;

	@Column(name = "TITLE", nullable = false, length = 50)
	@NotEmpty
	@Size(min = 3, max = 50)
	private String title;

	@Column(name = "VOTE")
	@Min(value = 1)
	@Max(value = 5)
	private int vote;

	@Column(name = "DESCRIPTION", nullable = false, length = 500)
	@NotEmpty
	@Size(min = 10, max = 500)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REGISTRATION_DATE", nullable = false)
	@NonNull
	@PastOrPresent
	private Date registrationDate;

	@ManyToOne
	@JoinColumn(name = "ID_USER")
	@NonNull
	private User user;

	@ManyToOne
	@JoinColumn(name = "ID_FERTILIZER")
	private Fertilizer fertilizer;

	@ManyToOne
	@JoinColumn(name = "ID_GROW")
	private Grow grow;

	@ManyToOne
	@JoinColumn(name = "ID_PLANT")
	private Plant plant;

	@ManyToOne
	@JoinColumn(name = "ID_STRAIN")
	private Strain strain;

	@ManyToOne
	@JoinColumn(name = "ID_SOIL_MIX")
	private SoilMix soilMix;

}
