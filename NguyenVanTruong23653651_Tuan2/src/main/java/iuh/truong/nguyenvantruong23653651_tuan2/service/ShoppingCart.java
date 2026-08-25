package iuh.truong.nguyenvantruong23653651_tuan2.service;


import iuh.truong.nguyenvantruong23653651_tuan2.model.CartItem;
import iuh.truong.nguyenvantruong23653651_tuan2.model.Product;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final List<CartItem> items = new ArrayList<>();

    public void add(Product product) {
        items.stream()
                .filter(item -> item.getProduct().getId() == product.getId())
                .findFirst()
                .ifPresentOrElse(CartItem::increaseQuantity, () -> items.add(new CartItem(product)));
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public int getItemCount() {
        return items.stream().mapToInt(CartItem::getQuantity).sum();
    }

    public BigDecimal getTotal() {
        return items.stream()
                .map(CartItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}