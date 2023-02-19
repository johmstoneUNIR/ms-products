package com.unir.msproducts.service;

import com.unir.msproducts.model.pojo.ElasticProduct;
import com.unir.msproducts.model.request.CreateProductRequest;

import java.util.List;

public interface ElasticProductService {
    
    ElasticProduct createProduct(CreateProductRequest request);

    ElasticProduct getProductById(String productid);

    ElasticProduct getProductByName(String productName);

    List<ElasticProduct> searchByDescription(String productDescription);

    List<ElasticProduct> searchByName(String productName);

    List<ElasticProduct> getAvailableProducts();
}
