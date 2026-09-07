/*
 * @ (#) ProductResource.java     1.0    9/6/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */
package iuh.fit.vantruong.nguyenvantruong_23653651_tuan2.cartapi.api;


import iuh.fit.vantruong.nguyenvantruong_23653651_tuan2.cartapi.service.ProductCatalog;
import iuh.fit.vantruong.nguyenvantruong_23653651_tuan2.cartapi.session.UserSession;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

/*
 * @description
 * @author:NguyenTruong
 * @date:  9/6/2026
 * @version:    1.0
 */
@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class ProductResource {

    @Inject
    ProductCatalog productCatalog;

    @Inject
    UserSession userSession;

    @GET
    public Response findAll() {
        if (!userSession.isLoggedIn()) {
            return Response.status(401)
                    .entity(Map.of(
                            "message",
                            "Bạn chưa đăng nhập"
                    ))
                    .build();
        }

        return Response.ok(
                productCatalog.findAll()
        ).build();
    }
}