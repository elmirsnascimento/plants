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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import br.com.esndev.plants.entity.base.BaseEntity;
import br.com.esndev.plants.enumerator.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PLANT", uniqueConstraints = @UniqueConstraint(columnNames = { "NAME" }))
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@SequenceGenerator(name = "SEQ_PLANT", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_PLANT")
public class Plant extends BaseEntity implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 6425977014812446983L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PLANT")
	private Long id;

	@Column(name = "NAME", nullable = false, length = 50)
	@NotEmpty
	@Size(min = 3, max = 50)
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name = "REGISTRATION_DATE", nullable = false)
	@NonNull
	@PastOrPresent
	private Date registrationDate;

	@Column(name = "VEGETATIVE_DATE", nullable = false)
	@NonNull
	@PastOrPresent
	private Date vegetativeDate;

	@Column(name = "FLOWERING_DATE", nullable = false)
	@NonNull
	@PastOrPresent
	private Date floweringDate;

	@Column(name = "HARVEST_DATE", nullable = false)
	@NonNull
	@PastOrPresent
	private Date harvestDate;

	@Column(name = "GENDER", nullable = true)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@ManyToOne
	@JoinColumn(name = "ID_STRAIN", nullable = true)
	private Strain strain;

	@ManyToOne
	@JoinColumn(name = "ID_LAST_LOG", nullable = false)
	@NonNull
	private Log lastLog;

	@ManyToOne
	@JoinColumn(name = "ID_USER", nullable = false)
	@NonNull
	private User user;

	@ManyToOne
	@JoinColumn(name = "ID_GROW", nullable = false)
	@NonNull
	private Grow grow;

	@OneToMany(mappedBy = "plant")
	@NotEmpty
	private Set<Log> log;

	@OneToMany(mappedBy = "plant")
	private Set<Comment> comments;

}
