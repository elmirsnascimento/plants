package br.com.esndev.plants.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum Yield {
	LOWER_THAN_1_OUNCE("LOWER_THAN_1_OUNCE"), BETWEEN_1_AND_3_OUNCES("BETWEEN_1_AND_3_OUNCES"), HIGHER_THAN_3_OUNCES("HIGHER_THAN_3_OUNCES");

	private @Getter @Setter String description;
}
