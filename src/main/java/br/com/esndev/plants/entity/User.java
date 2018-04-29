package br.com.esndev.plants.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.esndev.plants.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@SequenceGenerator(name = "SEQ_USER", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_USER")
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER")
	private Long id;

	@NotNull
	@Column(name = "NAME", length = 255, unique = true)
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name = "REGISTRATION_DATE", nullable = false)
	private Date registrationDate;

	@NotNull
	@Column(name = "EMAIL", length = 50, unique = true)
	private String email;

	@NotNull
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "PASSWORD", length = 255, unique = false)
	private String password;

	@OneToMany(mappedBy = "user")
	private Set<SoilMix> soilMixes;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private Set<Fertilizer> fertilizers;

	public User(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

}
