package br.com.esndev.plants.enumerator;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum UnitOfMeasureVolume {
	CUP("CUP"), LITER("LITER");

	private @Getter @Setter String description;

	public static UnitOfMeasureVolume getUnitOfMeasureVolumeForWhoeverAsk() {
		if (LocaleContextHolder.getLocale().equals(Locale.US)) {
			return CUP;
		} else {
			return LITER;
		}
	}
}
