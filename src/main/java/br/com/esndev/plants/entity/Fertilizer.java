package br.com.esndev.plants.entity;

import java.io.Serializable;
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

import br.com.esndev.plants.entity.base.BaseEntity;
import br.com.esndev.plants.enumerator.Stage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FERTILIZER")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class Fertilizer extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6052051281533323016L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME", nullable = false, length = 255)
	private String name;

	@ManyToOne
	@JoinColumn(name = "ID_COMPANY", nullable = true)
	private Company company;

	@ManyToMany(mappedBy = "fertilizers")
	private Set<SoilIngredient> soilIngredients;

	@Column(name = "DILUTABLE_IN_WATER", nullable = false)
	private boolean dilutableInWater;

	@Column(name = "NITROGEN_RATIO", nullable = true)
	private int nitrogenRatio;

	@Column(name = "PHOSPHORUS_RATIO", nullable = true)
	private int phosphorusRatio;

	@Column(name = "POTASSIUM_RATIO", nullable = true)
	private int potassiumRatio;

	@Column(name = "STAGE", nullable = false)
	@Enumerated(EnumType.STRING)
	private Stage stage;

	@ManyToOne
	@JoinColumn(name = "ID_USER", nullable = true)
	private User user;

	@OneToMany(mappedBy = "soilMix")
	private Set<Comment> comments;

	@ManyToMany(mappedBy = "fertilizers")
	private Set<Watering> watering;
}
