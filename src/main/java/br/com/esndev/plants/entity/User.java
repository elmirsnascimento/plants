package br.com.esndev.plants.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.esndev.plants.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(name = "NAME", length = 255, unique = true)
	private String name;
	
	@NotNull
    @Column(name= "EMAIL", length = 50, unique = true)
	private String email;
	
	@NotNull
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "PASSWORD", length = 255, unique = false)
	private String password;
	
	
	public User (Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	

}
