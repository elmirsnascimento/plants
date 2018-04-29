package br.com.esndev.plants.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.esndev.plants.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "GROW")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@SequenceGenerator(name = "SEQ_GROW", initialValue = 1, allocationSize = 1, sequenceName="SEQ_GROW")
public class Grow extends BaseEntity implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -4906606583950386420L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GROW")
	private @Getter @Setter Long id;

	@Column(name = "NAME", nullable = false, length = 255)
	private @Getter @Setter String name;

	@Temporal(TemporalType.DATE)
	@Column(name = "REGISTRATION_DATE")
	private @Getter @Setter Date registrationDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "EXPECT_END_DATE")
	private @Getter @Setter Date expectedEndingDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATE_DATE")
	private @Getter @Setter Date lastUpdateDate;

	@OneToMany(mappedBy = "grow")
	private Set<Comment> comments;

	@OneToMany(mappedBy = "grow")
	private Set<Plant> plants;
}
