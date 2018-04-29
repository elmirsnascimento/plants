package br.com.esndev.plants.filter;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.esndev.plants.enumerator.Stage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogFilter {

	private String description;

	private Long idPlant;

	private Long idGrow;
	
	private Boolean attended;

	private Date registrationDate;

	private Stage[] stages;

}
