package com.LucioGrammtico.AMS.Test.SimilarProducts.Services;

import com.LucioGrammtico.AMS.Test.SimilarProducts.Entities.ProductDetail;
import com.LucioGrammtico.AMS.Test.SimilarProducts.Entities.SimilarProduct;
import com.LucioGrammtico.AMS.Test.SimilarProducts.Utils.Utils;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


/**
 *
 * @author Lucio Grammatico
 */
@Service
@AllArgsConstructor
public class GetSimilarProductsService {

    private static final RestTemplate restTemplate = new RestTemplate();

    public List<ProductDetail> GetSimilarProducts(String productId) throws Exception {
        try {
            SimilarProduct similarProducts = GetSimilarIds(productId);
            return Utils.NonNullValues(GetDetails(similarProducts));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public SimilarProduct GetSimilarIds(String id) throws Exception {
        try {
            SimilarProduct similarProducts = new SimilarProduct();
            List<Integer> idList = restTemplate.getForObject("http://localhost:3001//product/" + id + "/similarids", List.class);
            similarProducts.setSimilarProducts(Utils.ListCaster(idList));
            return similarProducts;
        } catch (RestClientException e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<ProductDetail> GetDetails(SimilarProduct similarProducts) {
        List<ProductDetail> productDetails = new ArrayList();
        for (String similarProduct : similarProducts.getSimilarProducts()) {
            productDetails.add(GetDetail(similarProduct));
        }
        return productDetails;
    }

    public ProductDetail GetDetail(String id) {
        try {
            return restTemplate.getForObject("http://localhost:3001//product/" + id, ProductDetail.class);
        } catch (RestClientException e) {
            return null;
        }

    }

}
