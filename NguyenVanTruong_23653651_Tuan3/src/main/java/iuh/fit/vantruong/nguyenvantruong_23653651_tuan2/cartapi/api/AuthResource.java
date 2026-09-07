/*
 * @ (#) AuthResource.java     1.0    9/6/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */
package iuh.fit.vantruong.nguyenvantruong_23653651_tuan2.cartapi.api;


/*
 * @description
 * @author:NguyenTruong
 * @date:  9/6/2026
 * @version:    1.0
 */

import iuh.fit.vantruong.nguyenvantruong_23653651_tuan2.cartapi.service.AuthenticationService;
import iuh.fit.vantruong.nguyenvantruong_23653651_tuan2.cartapi.session.UserSession;
import jakarta.enterprise.context.RequestScoped;

import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class AuthResource {

    @Inject
    AuthenticationService authenticationService;

    @Inject
    UserSession userSession;

    @POST
    @Path("/login")
    public Response login(
            LoginRequest body,
            @Context HttpServletRequest request
    ) {
        if (body == null
                || !authenticationService.authenticate(
                body.username(),
                body.password()
        )) {

            return Response.status(
                            Response.Status.UNAUTHORIZED
                    )
                    .entity(Map.of(

                            "message",
                            "Sai tài khoản hoặc mật khẩu"
                    ))
                    .build();
        }

        // Đảm bảo HttpSession được khởi tạo để CDI SessionContext hoạt động và gửi JSESSIONID cookie về client
        request.getSession(true);

        userSession.login(body.username());

        return Response.ok(Map.of(
                "loggedIn", true,
                "username", userSession.getUsername(),
                "instanceId",
                userSession.getInstanceId()
        )).build();
    }

    public record LoginRequest(
            String username,
            String password
    ) {
    }
    @GET
    @Path("/session")
    public Map<String, Object> session() {
        return Map.of(
                "loggedIn", userSession.isLoggedIn(),
                "username",
                userSession.getUsername() == null
                        ? ""
                        : userSession.getUsername(),
                "instanceId",
                userSession.getInstanceId()
        );
    }
    @DELETE
    @Path("/session")
    public Response logout(
            @Context HttpServletRequest request
    ) {
        if (request.getSession(false) != null) {
            request.getSession(false).invalidate();

        }

        return Response.noContent().build();
    }
}