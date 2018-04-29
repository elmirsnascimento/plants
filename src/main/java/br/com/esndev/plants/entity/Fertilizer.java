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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.esndev.plants.entity.base.BaseEntity;
import br.com.esndev.plants.enumerator.Stage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FERTILIZER", uniqueConstraints = @UniqueConstraint(columnNames = { "NAME", "ID_USER"}))
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@SequenceGenerator(name = "SEQ_FERTILIZER", initialValue = 1, allocationSize = 1, sequenceName="SEQ_FERTILIZER")
public class Fertilizer extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6052051281533323016L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FERTILIZER")
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

	@Column(name = "WATER_PUMPED", nullable = false)
	private boolean waterPumped;

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
