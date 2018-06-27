package br.com.esndev.plants.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.esndev.plants.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SOIL_INGREDIENT", uniqueConstraints = @UniqueConstraint(columnNames = { "NAME" }))
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@SequenceGenerator(name = "SEQ_SOIL_INGREDIENT", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_SOIL_INGREDIENT")
public class SoilIngredient extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1836975409762015978L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SOIL_INGREDIENT")
	private Long id;

	@Column(name = "NAME", nullable = false, length = 50)
	@NotEmpty
	@Size(min=3, max=50)
	private String name;

	@ManyToMany
	private Set<Fertilizer> fertilizers;

	@OneToMany(mappedBy = "soilIngredient")
	private Set<IngredientConcentration> ingredientConcentrations;

}
