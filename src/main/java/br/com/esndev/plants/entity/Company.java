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

import br.com.esndev.plants.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "COMPANY", uniqueConstraints = @UniqueConstraint(columnNames = { "NAME"}))
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

	@Column(name = "NAME", nullable = false, length = 255)
	private String name;
}
