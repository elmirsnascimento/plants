package br.com.esndev.plants.filter;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageFilter {

	private Long idElement;
	
	private boolean userElement;

	private boolean fertilizerElement;
	
	private boolean growElement;
	
	private boolean plantElement;
	
	private boolean strainElement;
	
	private boolean soilMixElement;

}
