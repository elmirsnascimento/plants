package br.com.esndev.plants.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum RequiredExpertize {
	LOW("LOW"), MODERATED("MODERATED"), HIGH("HIGH");

	private @Getter @Setter String description;

}
