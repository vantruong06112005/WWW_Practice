package iuh.truong.nguyenvantruong23653651_tuan2.web;



import iuh.truong.nguyenvantruong23653651_tuan2.model.Product;
import iuh.truong.nguyenvantruong23653651_tuan2.service.ProductCatalog;
import iuh.truong.nguyenvantruong23653651_tuan2.service.ShoppingCart;
import iuh.truong.nguyenvantruong23653651_tuan2.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.Optional;

@WebServlet("/cart/add")
public class CartServlet extends HttpServlet {
    @Inject
    private ProductCatalog productCatalog;

    @Inject
    private UserSession userSession;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!userSession.isLoggedIn()) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        try {
            long productId = Long.parseLong(request.getParameter("productId"));
            Optional<Product> optionalProduct = productCatalog.findById(productId);
            if (optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                ShoppingCart shoppingCart = userSession.getShoppingCart();
                shoppingCart.add(product);
            }
        } catch (NumberFormatException ignored) {
            // ID không hợp lệ: không thay đổi giỏ hàng.
        }

        response.sendRedirect(request.getContextPath() + "/products");
    }
}