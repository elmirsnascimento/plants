package br.com.esndev.plants.entity.base;

import lombok.Data;

@Data
public class BaseEntity implements Cloneable {

	private Long id;
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
