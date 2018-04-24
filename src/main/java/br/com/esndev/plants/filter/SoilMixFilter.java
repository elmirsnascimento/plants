package br.com.esndev.plants.filter;

import org.springframework.stereotype.Component;

import br.com.esndev.plants.entity.SoilIngredient;
import br.com.esndev.plants.enumerator.Stage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoilMixFilter {

	private String name;
	
	private String userName;
	
	private Stage[] mostSuitableStages;

	private SoilIngredient[] soilIngredients;
	
	
	
}
