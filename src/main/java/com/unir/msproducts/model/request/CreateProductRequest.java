package com.unir.msproducts.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {

	private String name;
	private String description;
    private String imageurl;
    private float price;
	private Boolean visible;
}
