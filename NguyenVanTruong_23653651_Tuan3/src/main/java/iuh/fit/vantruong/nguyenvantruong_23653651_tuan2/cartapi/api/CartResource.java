/*
 * @ (#) CartResource.java     1.0    9/7/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */
package iuh.fit.vantruong.nguyenvantruong_23653651_tuan2.cartapi.api;


import iuh.fit.vantruong.nguyenvantruong_23653651_tuan2.cartapi.model.Product;
import iuh.fit.vantruong.nguyenvantruong_23653651_tuan2.cartapi.service.ProductCatalog;
import iuh.fit.vantruong.nguyenvantruong_23653651_tuan2.cartapi.service.ShoppingCart;
import iuh.fit.vantruong.nguyenvantruong_23653651_tuan2.cartapi.session.UserSession;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;
import java.util.Optional;

/*
 * @description
 * @author:NguyenTruong
 * @date:  9/7/2026
 * @version:    1.0
 */
@Path("/cart")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped

public class CartResource {

    @Inject
    ProductCatalog productCatalog;

    @Inject
    UserSession userSession;

    @GET
    public Response getCart() {
        if (!userSession.isLoggedIn()) {
            return unauthorized();
        }

        return Response.ok(cartBody()).build();
    }

    @POST
    @Path("/items")
    public Response addItem(
            AddItemRequest request
    ) {
        if (!userSession.isLoggedIn()) {
            return unauthorized();
        }

        Optional<Product> product =
                request == null
                        ? Optional.empty()
                        : productCatalog.findById(
                        request.productId()
                );

        if (product.isEmpty()) {
            return Response.status(404)
                    .entity(Map.of(
                            "message",
                            "Không tìm thấy sản phẩm"
                    ))
                    .build();
        }

        userSession.getShoppingCart()
                .add(product.get());

        return Response.ok(cartBody()).build();
    }


    private Map<String, Object> cartBody() {
        ShoppingCart cart =
                userSession.getShoppingCart();

        return Map.of(
                "items", cart.getItems(),
                "itemCount", cart.getItemCount(),
                "total", cart.getTotal()
        );
    }

    private Response unauthorized() {
        return Response.status(401)
                .entity(Map.of(
                        "message",
                        "Bạn chưa đăng nhập"
                ))
                .build();
    }

    public record AddItemRequest(long productId) {
    }
}