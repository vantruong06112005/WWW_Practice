/*
 * @ (#) ProductCatalog.java     1.0    9/6/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */
package iuh.fit.vantruong.nguyenvantruong_23653651_tuan2.cartapi.service;


/*
 * @description
 * @author:NguyenTruong
 * @date:  9/6/2026
 * @version:    1.0
 */



import iuh.fit.vantruong.nguyenvantruong_23653651_tuan2.cartapi.model.Product;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductCatalog {

    private final List<Product> products = List.of(new Product(1, "Laptop", new BigDecimal("1500.00")), new Product(2, "Keyboard", new BigDecimal("80.00")), new Product(3, "Mouse",
                    new BigDecimal(100))

                );

    public List<Product> findAll() {
        return products;
    }

        public Optional<Product> findById(long id) {
        return products.stream().filter(product -> product.getId() == id).findFirst();
    }
}
//@ApplicationScoped nghĩa là CDI tạo một ProductCatalog dùng chung cho toàn ứng
//dụng.