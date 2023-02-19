package com.unir.msproducts.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import com.unir.msproducts.data.ElasticsearchRepository;
import com.unir.msproducts.model.pojo.ElasticProduct;
import com.unir.msproducts.model.request.CreateProductRequest;

@RequiredArgsConstructor
@Service
public class ElasticProductServiceImpl implements ElasticProductService {

    private final ElasticsearchRepository repo;

    @Override
    public ElasticProduct getProductById(String productId) {
        return repo.getById(productId);
    }

    @Override
    public ElasticProduct getProductByName(String productName) {
        return repo.getByName(productName);
    }

    @Override
    public List<ElasticProduct> searchByDescription(String productDescription) {
        return repo.searchByDescription(productDescription);
    }

    @Override
    public List<ElasticProduct> searchByName(String productName) {
        return repo.searchByName(productName);
    }

    @Override
    public List<ElasticProduct> getAvailableProducts() {
        return repo.getVisible();
    }

    @Override
    public ElasticProduct createProduct(CreateProductRequest request) {

        if (request != null && StringUtils.hasLength(request.getName().trim())
                && StringUtils.hasLength(request.getDescription().trim())
                && StringUtils.hasLength(String.valueOf(request.getPrice()))
                && request.getVisible() != null) {

            ElasticProduct product = ElasticProduct.builder()
                    .id(String.valueOf(request.getName().hashCode()))
                    .name(request.getName())
                    .price(request.getPrice())
                    .description(request.getDescription())
                    .imageurl(request.getImageurl())                    
                    .visible(request.getVisible())
                    .build();

            return repo.saveProduct(product);
        } else {
            return null;
        }
    }

}
