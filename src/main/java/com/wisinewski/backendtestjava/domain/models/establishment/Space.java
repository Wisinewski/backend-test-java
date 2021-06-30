package com.wisinewski.backendtestjava.domain.models.establishment;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wisinewski.backendtestjava.domain.models.params.establishment.SpaceParams;

@Entity
@Table(name = "spaces")
public class Space implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer spaceType;
	private Integer quantityOfSpaces;
	
	public Space() {
	}
	
	public Space(Long id, Integer spaceType, Integer quantityOfSpaces) {
		this.id = id;
		this.spaceType = spaceType;
		this.quantityOfSpaces = quantityOfSpaces;
	}
	
	public static Space parseSpace(SpaceParams spaceParams) {
		return new Space(null, spaceParams.getSpaceType(), spaceParams.getQuantityOfSpaces());
	}

	public Long getId() {
		return id;
	}

	public Integer getType() {
		return spaceType;
	}

	public Integer getQuantityOfSpaces() {
		return quantityOfSpaces;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Space other = (Space) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
