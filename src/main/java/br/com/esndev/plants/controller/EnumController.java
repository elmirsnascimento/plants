package br.com.esndev.plants.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.esndev.plants.enumerator.Flowering;
import br.com.esndev.plants.enumerator.Gender;
import br.com.esndev.plants.enumerator.LightType;
import br.com.esndev.plants.enumerator.RequiredExpertize;
import br.com.esndev.plants.enumerator.Specie;
import br.com.esndev.plants.enumerator.Stage;
import br.com.esndev.plants.enumerator.UnitOfMeasureHeight;
import br.com.esndev.plants.enumerator.UnitOfMeasureVolume;
import br.com.esndev.plants.enumerator.UnitOfMeasureWeight;

@RestController
@RequestMapping("/plants/enum")
public class EnumController {

	@GetMapping(value = "/flowering")
	public Flowering[] getAllFlowering() {
		return Flowering.values();
	}

	@GetMapping(value = "/gender")
	public Gender[] getAllGender() {
		return Gender.values();
	}

	@GetMapping(value = "/lighttype")
	public LightType[] getAllLightType() {
		return LightType.values();
	}

	@GetMapping(value = "/requiredexpertize")
	public RequiredExpertize[] getAllRequiredExpertize() {
		return RequiredExpertize.values();
	}

	@GetMapping(value = "/specie")
	public Specie[] getAllSpecie() {
		return Specie.values();
	}

	@GetMapping(value = "/stage")
	public Stage[] getAllStage() {
		return Stage.values();
	}

	@GetMapping(value = "/height")
	public UnitOfMeasureHeight getUnitOfMeasureHeight() {
		return UnitOfMeasureHeight.getUnitOfMeasureHeightForWhoeverAsk();
	}

	@GetMapping(value = "/weight")
	public UnitOfMeasureWeight getUnitOfMeasureWeight() {
		return UnitOfMeasureWeight.getUnitOfMeasureWeightForWhoeverAsk();
	}

	@GetMapping(value = "/volume")
	public UnitOfMeasureVolume getUnitOfMeasureVolume() {
		return UnitOfMeasureVolume.getUnitOfMeasureVolumeForWhoeverAsk();
	}

}
