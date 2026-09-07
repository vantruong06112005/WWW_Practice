/*
 * @ (#) ShoppingCart.java     1.0    9/6/2026
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

import iuh.fit.vantruong.nguyenvantruong_23653651_tuan2.cartapi.model.CartItem;
import iuh.fit.vantruong.nguyenvantruong_23653651_tuan2.cartapi.model.Product;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final List<CartItem> items =
            new ArrayList<>();

    public void add(Product product) {
        for (CartItem item : items) {
            if (item.getProduct().getId()
                    == product.getId()) {
                item.increaseQuantity();
                return;
            }
        }

        items.add(new CartItem(product));
    }

    public List<CartItem> getItems() {
        //tạo ra một danh sách chỉ đọc.
        return Collections.unmodifiableList(items);
    }

    public int getItemCount() {
        return items.stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
    }

    public BigDecimal getTotal() {
        return items.stream()
                .map(CartItem::getSubtotal)
                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );
    }
}