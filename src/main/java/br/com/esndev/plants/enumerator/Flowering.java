package br.com.esndev.plants.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum Flowering {
	LOWER_THAN_9("LOWER_THAN_9"), BETWEEN_9_AND_12("BETWEEN_9_AND_12"), HIGHER_THAN_12("HIGHER_THAN_12");

	private @Getter @Setter String description;
}
