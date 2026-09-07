/*
 * @ (#) UserSession.java     1.0    9/6/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */
package iuh.fit.vantruong.nguyenvantruong_23653651_tuan2.cartapi.session;


/*
 * @description
 * @author:NguyenTruong
 * @date:  9/6/2026
 * @version:    1.0
 */

import iuh.fit.vantruong.nguyenvantruong_23653651_tuan2.cartapi.service.ShoppingCart;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.SessionScoped;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@SessionScoped
public class UserSession implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String instanceId =
            UUID.randomUUID().toString();

    private final ShoppingCart shoppingCart =
            new ShoppingCart();

    private String username;

    @PostConstruct
    public void created() {
        System.out.println(
                "CREATED UserSession: " + instanceId
        );
    }

    @PreDestroy
    public void destroyed() {
        System.out.println(
                "DESTROYED UserSession: " + instanceId
        );
    }

    public void login(String username) {
        this.username = username;
    }


    public boolean isLoggedIn() {
        return username != null;
    }

    public String getUsername() {
        return username;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}