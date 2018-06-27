package br.com.esndev.plants.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

import br.com.esndev.plants.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SOIL_INGREDIENT_CONCENTRATION")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class IngredientConcentration extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1034834126606655165L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "CONCENTRATION", nullable = false)
	@NonNull
	@Min(value = 0)
	@Max(value = 100)
	private Integer concentration;

	@ManyToOne
	@JoinColumn(name = "ID_SOIL_INGREDIENT", nullable = false)
	@NonNull
	private SoilIngredient soilIngredient;

	@ManyToMany
	@NotEmpty
	private Set<SoilMix> soilMixes;
	
	@ManyToOne
	@JoinColumn(name = "ID_USER")
	@NonNull
	private User user;

}
