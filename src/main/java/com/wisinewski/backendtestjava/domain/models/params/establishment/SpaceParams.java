package com.wisinewski.backendtestjava.domain.models.params.establishment;

public class SpaceParams {

	private Integer spaceType;
	private Integer quantityOfSpaces;
	
	public SpaceParams(Integer spaceType, Integer quantityOfSpaces) {
		this.spaceType = spaceType;
		this.quantityOfSpaces = quantityOfSpaces;
	}

	public Integer getSpaceType() {
		return spaceType;
	}

	public Integer getQuantityOfSpaces() {
		return quantityOfSpaces;
	}
	
}
