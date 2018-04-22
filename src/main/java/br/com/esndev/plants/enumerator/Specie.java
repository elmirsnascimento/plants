package br.com.esndev.plants.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum Specie {

	SATIVA("SATIVA"), INDICA("INDICA"), HYBRID("HYBRID"), RUDERALIS("RUDERALIS");

	private @Getter @Setter String description;
}
