package iuh.truong.nguyenvantruong23653651_tuan2.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        return "student".equals(username) && "123456".equals(password);
    }
}