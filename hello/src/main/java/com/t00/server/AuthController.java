package com.t00.server;



import com.t00.pojo.LoginRequest;
import com.t00.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        if ("test".equals(loginRequest.getUsername()) && "123456".equals(loginRequest.getPassword())) {
            String token = JwtUtil.generateToken(loginRequest.getUsername());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("用户名或密码错误");
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
