package com.wisinewski.backendtestjava.domain.models.establishment;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.wisinewski.backendtestjava.domain.models.vehicle.VehicleType;

@Entity
@Table(name = "spaces")
public class Space implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_vehicle_type")
	private VehicleType spaceType;
	private Integer quantityOfSpaces;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="id_establishment")
	private Establishment establishment;
	
	public Space(Long id, VehicleType spaceType, Integer quantityOfSpaces) {
		this.id = id;
		this.spaceType = spaceType;
		this.quantityOfSpaces = quantityOfSpaces;
	}

	public Long getId() {
		return id;
	}

	public VehicleType getType() {
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
