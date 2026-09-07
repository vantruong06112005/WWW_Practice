/*
 * @ (#) CartItem.java     1.0    9/6/2026
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

public class CartItem implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Product product;
    private int quantity = 1;

    public CartItem(Product product) {
        this.product = product;
    }

    public void increaseQuantity() {
        quantity++;

    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getSubtotal() {
        return product.getPrice()
                .multiply(BigDecimal.valueOf(quantity));
    }
}