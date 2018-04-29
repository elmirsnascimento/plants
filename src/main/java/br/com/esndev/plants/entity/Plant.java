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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.esndev.plants.entity.base.BaseEntity;
import br.com.esndev.plants.enumerator.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PLANT")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class Plant extends BaseEntity implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 6425977014812446983L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME", nullable = false, length = 255)
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name = "REGISTRATION_DATE", nullable = false)
	private Date registrationDate;

	@Column(name = "WEEKS_TO_LIVE", nullable = false)
	private int weeksToLive;

	@Column(name = "GENDER", nullable = true)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@ManyToOne
	@JoinColumn(name = "ID_STRAIN", nullable = true)
	private Strain strain;
	
	@ManyToOne
	@JoinColumn(name = "ID_LAST_LOG", nullable = false)
	private Log lastLog;

	@ManyToOne
	@JoinColumn(name = "ID_GROW", nullable = false)
	private Grow grow;

	@OneToMany(mappedBy = "plant")
	private Set<Log> log;

}
