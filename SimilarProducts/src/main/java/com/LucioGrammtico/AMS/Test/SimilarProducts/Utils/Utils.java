package com.LucioGrammtico.AMS.Test.SimilarProducts.Utils;

import com.LucioGrammtico.AMS.Test.SimilarProducts.Entities.ProductDetail;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> ListCaster(List<Integer> integerList) {
        List<String> list = new ArrayList();
        for (Integer integer : integerList) {
            list.add(integer.toString());
        }
        return list;
    }

    public static List<ProductDetail> NonNullValues(List<ProductDetail> nullList) {
       List<ProductDetail> list = new ArrayList();
        for (ProductDetail pd : nullList) {
            if (pd != null) {
                list.add(pd);
            }
        }
        return list;
    }
}
