package com.cms.controller.login;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.common.data.ImsResponse;

@RestController
@RequestMapping("/react")
public class ReactLoginController {

    @PostMapping("/login")
    public ImsResponse login(@RequestBody User user) {
        // 这里简单的验证逻辑，可以根据需要进行修改
        if ("admin".equals(user.getUsername()) && "password".equals(user.getPassword()) || "user".equals(user.getUsername()) && "password".equals(user.getPassword())) {
            return new ImsResponse(true);
        }
        return new ImsResponse(false,"ユーザとパスワードは正確ではなく");
    }

    static class User {
        private String username;
        private String password;

        // getters and setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}