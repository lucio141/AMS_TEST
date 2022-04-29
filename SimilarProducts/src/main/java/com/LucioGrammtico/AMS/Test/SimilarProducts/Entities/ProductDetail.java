package com.LucioGrammtico.AMS.Test.SimilarProducts.Entities;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Lucio Grammatico
 */
@Getter
@Setter
public class ProductDetail {
    private String id;
    private String name;
    private float price;
    private boolean availability;
}