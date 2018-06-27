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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import br.com.esndev.plants.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "IMAGE")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@SequenceGenerator(name = "SEQ_IMAGE", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_IMAGE")
public class Image extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6193509293186476709L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_IMAGE")
	private @Getter @Setter Long id;

	@Column(name = "NAME", nullable = false, length = 50)
	@NotEmpty
	@Size(min = 3, max = 50)
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name = "REGISTRATION_DATE", nullable = false)
	@NonNull
	@PastOrPresent
	private Date registrationDate;

	@Column(name = "WIDTH", nullable = false)
	@NonNull
	private float width;

	@Column(name = "HEIGHT", nullable = false)
	@NonNull
	private float height;

	@Column(name = "CONTENT_TYPE", nullable = false)
	@NonNull
	private String contentType;

	@OneToOne
	@JoinColumn(name = "ID_USER")
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
