package br.com.esndev.plants.filter;

import org.springframework.stereotype.Component;

import br.com.esndev.plants.enumerator.Flowering;
import br.com.esndev.plants.enumerator.Height;
import br.com.esndev.plants.enumerator.RequiredExpertize;
import br.com.esndev.plants.enumerator.Specie;
import br.com.esndev.plants.enumerator.Yield;
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

	private Height[] heightes;

	private Yield[] yields;
	
	private Flowering[] flowerings;
	

}
