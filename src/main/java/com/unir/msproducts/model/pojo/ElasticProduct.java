package com.unir.msproducts.model.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(indexName = "products", createIndex = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ElasticProduct {
 
    @Id
    private String id;
 
    @MultiField(mainField = @Field(type = FieldType.Keyword, name = "name"),
        otherFields = @InnerField(suffix = "search", type = FieldType.Text))
    private String name;

    @Field(type = FieldType.Float, name = "price")
    private Float price;

    @Field(type = FieldType.Text, name = "imageurl")
    private String imageurl;

    @Field(type = FieldType.Search_As_You_Type, name = "description")
    private String description;

    @Field(type = FieldType.Boolean, name = "visible")
    private boolean visible;
}
