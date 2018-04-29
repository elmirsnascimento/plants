package br.com.esndev.plants.filter;

import org.springframework.stereotype.Component;

import br.com.esndev.plants.enumerator.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantFilter {

	private Long idPlant;

	private String name;

	private Gender[] genders;

	private Boolean inVegetativeStage;

	private Boolean inFloweringStage;

	private Boolean stillAlive;

	private Long[] idsStrains;

	private Long idGrow;

}
