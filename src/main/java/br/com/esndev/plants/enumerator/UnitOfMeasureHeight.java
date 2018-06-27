package br.com.esndev.plants.enumerator;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum UnitOfMeasureHeight {
	INCH("INCH"), CENTIMETER("CENTIMETER");

	private @Getter @Setter String description;
	
	public static UnitOfMeasureHeight getUnitOfMeasureHeightForWhoeverAsk() {
		if(LocaleContextHolder.getLocale().equals(Locale.US)) {
			return INCH;
		}else {
			return CENTIMETER;
		}
	}
}
