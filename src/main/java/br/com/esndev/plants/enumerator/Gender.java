package br.com.esndev.plants.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum Gender {
	FEMALE("FEMALE"), MALE("MALE"), HERMAPHRODITE("HERMAPHRODITE");

	private @Getter @Setter String description;
}
