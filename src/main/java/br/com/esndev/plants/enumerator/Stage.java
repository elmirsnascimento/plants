package br.com.esndev.plants.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum Stage {
	SEED("SEED"), SEEDLING("SEEDLING"), VEGETATIVE("VEGETATIVE"), FLOWERING("FLOWERING"), HARVEST("HARVEST");

	private @Getter @Setter String description;
}
