package br.com.esndev.plants.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.esndev.plants.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "COMPANY")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class Company extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2225755507631569415L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME", nullable = false, length = 255)
	private String name;
}