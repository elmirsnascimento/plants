package br.com.esndev.plants.filter;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrowFilter {

	private String name;

	private Long idPlant;

	private Long idUser;

	private Boolean terminated;

	private Long[] idsStrains;

}
