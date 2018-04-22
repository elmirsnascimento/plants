package br.com.esndev.plants.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum Height {
	LOWER_THAN_30("LOWER_THAN_30"), BETWEEN_30_78("BETWEEN_30_AND_78"), HIGHER_THAN_78("HIGHER_THAN_78");

	private @Getter @Setter String description;
}
