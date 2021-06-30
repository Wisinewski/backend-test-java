package com.wisinewski.backendtestjava.domain.models.establishment;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wisinewski.backendtestjava.domain.models.params.establishment.PhoneParams;

@Entity
@Table(name = "phones")
public class Phone implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ddd;
	private String phoneNumber;
	
	public Phone() {
	}
	
	public Phone(Long id, String ddd, String phoneNumber) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.phoneNumber = phoneNumber;
	}
	
	public static Phone parsePhone(PhoneParams phoneParams) {
		return new Phone(null, phoneParams.getDdd(), phoneParams.getPhoneNumber());
	}

	public Long getId() {
		return id;
	}

	public String getDdd() {
		return ddd;
	}

	public String getPhoneNumber() {
		return phoneNumber;
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
		Phone other = (Phone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
