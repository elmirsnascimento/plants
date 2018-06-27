package br.com.esndev.plants.enumerator;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum UnitOfMeasureWeight {
	OUNCE("OUNCE"), GRAM("GRAM");

	private @Getter @Setter String description;

	public static UnitOfMeasureWeight getUnitOfMeasureWeightForWhoeverAsk() {
		if (LocaleContextHolder.getLocale().equals(Locale.US)) {
			return OUNCE;
		} else {
			return GRAM;
		}
	}
}
