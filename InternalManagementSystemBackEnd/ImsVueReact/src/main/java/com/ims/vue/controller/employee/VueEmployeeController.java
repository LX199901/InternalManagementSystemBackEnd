package com.ims.vue.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ims.vue.service.HelloWorldService;

@RestController
@RequestMapping("/vue/employee")
public class VueEmployeeController {

	@Autowired
	private HelloWorldService service;

    @PostMapping("/init")
    public Response login(@RequestBody User user) {
        // 这里简单的验证逻辑，可以根据需要进行修改
        if ("admin".equals(user.getUsername()) && "password".equals(user.getPassword())) {
            return new Response(true);
        }
        return new Response(false);
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

    static class Response {
        private boolean success;

        public Response(boolean success) {
            this.success = success;
        }

        // getter
        public boolean isSuccess() {
            return success;
        }
    }
}