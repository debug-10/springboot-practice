package top.guke.springboot.configure.controller;


import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.guke.springboot.configure.util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/jwt")
@AllArgsConstructor
public class JwtController{
    private final JwtUtil jwtUtil;

    /**
     *
     * @param username
     * @return
     */

    @PostMapping("/generate")
    public Map<String,String> generateToken(@RequestParam String username){
        Map<String , Object>claims = new HashMap<>();
        claims.put("username", username);
        String token = jwtUtil.generateToken(claims);
        Map<String,String> response = new HashMap<>();
        response.put("token" , token);
        return response;
    }

    @PostMapping("/validate")
    public Map<String,Object> validateToken(@RequestParam String token){
        boolean isVaild = jwtUtil.validateToken(token);
        Map<String , Object> response= new HashMap<>();
        response.put("valid" , token);
        return response;
    }
}
