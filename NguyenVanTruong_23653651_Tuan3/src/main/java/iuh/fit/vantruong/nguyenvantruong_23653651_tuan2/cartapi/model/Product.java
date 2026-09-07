/*
 * @ (#) Product.java     1.0    9/6/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */
package iuh.fit.vantruong.nguyenvantruong_23653651_tuan2.cartapi.model;


/*
 * @description
 * @author:NguyenTruong
 * @date:  9/6/2026
 * @version:    1.0
 */

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final long id;
    private final String name;
    private final BigDecimal price;

    public Product(
            long id,
            String name,
            BigDecimal price
    ) {
        this.id = id;

        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
