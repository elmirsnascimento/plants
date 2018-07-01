package br.com.esndev.plants.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.esndev.plants.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "COMPANY", uniqueConstraints = @UniqueConstraint(columnNames = { "NAME" }))
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@SequenceGenerator(name = "SEQ_COMPANY", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_COMPANY")
public class Company extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2225755507631569415L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMPANY")
	private Long id;

	@Column(name = "NAME", nullable = false, length = 50)
	@NotEmpty(message = "Field Name must not be empty")
	@Size(min = 2, max = 50, message = " Field Name must have between {min} and {max} characters")
	private String name;

	@Override
	public boolean equalsValidationForUpdate(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (id == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
}
