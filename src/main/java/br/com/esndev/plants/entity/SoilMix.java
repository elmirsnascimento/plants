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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import br.com.esndev.plants.entity.base.BaseEntity;
import br.com.esndev.plants.enumerator.Stage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SOIL_MIX", uniqueConstraints = @UniqueConstraint(columnNames = { "NAME", "ID_USER" }))
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class SoilMix extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4330310401884965045L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME", nullable = false, length = 255)
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name = "REGISTRATION_DATE", nullable = false)
	private Date registrationDate;

	@Column(name = "MOST_SUITABLE_STAGE")
	@Enumerated(EnumType.STRING)
	private Stage mostSuitableStage;

	@ManyToMany(mappedBy = "soilMixes")
	private Set<IngredientConcentration> ingredientConcentrations;

	@OneToMany(mappedBy = "soilMix")
	private Set<Log> logs;

	@ManyToOne
	@JoinColumn(name = "ID_USER")
	private User user;

	@OneToMany(mappedBy = "soilMix")
	private Set<Comment> comments;

}
