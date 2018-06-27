package br.com.esndev.plants.filter;

import org.springframework.stereotype.Component;

import br.com.esndev.plants.enumerator.Flowering;
import br.com.esndev.plants.enumerator.RequiredExpertize;
import br.com.esndev.plants.enumerator.Specie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StrainFilter {

	private String name;

	private Specie[] species;

	private RequiredExpertize[] requiredExpertizes;

	private Float minHeight;

	private Float maxHeight;

	private Float minYield;

	private Float maxYield;

	private Flowering[] flowerings;

}
