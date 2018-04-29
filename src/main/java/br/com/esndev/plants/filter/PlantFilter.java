package br.com.esndev.plants.filter;

import org.springframework.stereotype.Component;

import br.com.esndev.plants.enumerator.Flowering;
import br.com.esndev.plants.enumerator.Gender;
import br.com.esndev.plants.enumerator.Height;
import br.com.esndev.plants.enumerator.Yield;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantFilter {

	private String name;

	private Gender[] genders;

	private Integer weeksToLive;

	private Boolean stillAlive;

	private Long[] idsStrains;

	private Long idGrow;

}
