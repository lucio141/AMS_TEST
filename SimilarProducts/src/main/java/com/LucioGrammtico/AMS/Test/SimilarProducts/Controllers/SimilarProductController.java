package com.LucioGrammtico.AMS.Test.SimilarProducts.Controllers;

import com.LucioGrammtico.AMS.Test.SimilarProducts.Services.GetSimilarProductsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author Lucio Grammatico
 */
@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class SimilarProductController {

private final GetSimilarProductsService service;

    @GetMapping("/{productId}/similar")
    @ResponseBody
    public ResponseEntity GetSimilarProducts(@PathVariable String productId) throws Exception{       
        try {
return ResponseEntity.status(HttpStatus.OK).body(service.GetSimilarProducts(productId));
        } catch (Exception e) {
return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }
    }
}
