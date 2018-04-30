package br.com.esndev.plants.filter;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WateringFilter {

	private Boolean skip;

	private Long[] idsFertilizers;

	private Long idLog;

}
