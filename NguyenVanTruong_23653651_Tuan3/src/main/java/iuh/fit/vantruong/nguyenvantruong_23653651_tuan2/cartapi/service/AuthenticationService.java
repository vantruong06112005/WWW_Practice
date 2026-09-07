/*
 * @ (#) AuthenticationService.java     1.0    9/6/2026
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

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthenticationService {

    public boolean authenticate(
            String username,
            String password
    ) {
        return "student".equals(username)
                && "123456".equals(password);
    }
}