package br.com.esndev.plants.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum LightType {

	HQL("HQL"), HQI("HQI"), FLUORESCENT("FLUORESCENT"), LED("LED");

	private @Getter @Setter String description;

}
