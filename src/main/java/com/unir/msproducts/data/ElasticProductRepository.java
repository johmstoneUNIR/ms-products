package com.unir.msproducts.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.unir.msproducts.model.pojo.ElasticProduct;

public interface ElasticProductRepository extends ElasticsearchRepository<ElasticProduct, String> {

    Optional<ElasticProduct> findByName(String name);

    List<ElasticProduct> findByDescription(String description);

    List<ElasticProduct> findByVisible(Boolean visible);
    
}
