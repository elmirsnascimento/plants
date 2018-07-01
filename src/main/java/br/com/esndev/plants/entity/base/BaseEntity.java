package br.com.esndev.plants.entity.base;

import lombok.Data;

@Data
public class BaseEntity implements Cloneable {

	private Long id;

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public boolean equalsValidationForUpdate(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
