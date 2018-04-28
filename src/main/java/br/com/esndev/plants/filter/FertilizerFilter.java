package br.com.esndev.plants.filter;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FertilizerFilter {

	private String name;

	private Long[] idsSoilIngredients;

	private Long idCompany;

	private Long idUser;

	private Integer nitrogenRatio;

	private Integer phosphorusRatio;

	private Integer potassiumRatio;

	private Boolean onlyThoseOwnedByMyUser;

}
