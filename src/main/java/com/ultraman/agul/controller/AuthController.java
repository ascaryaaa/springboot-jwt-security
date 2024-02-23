package com.ultraman.agul.controller;


import com.ultraman.agul.config.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/api/auth")
public class AuthController {


    private final AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;


    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;


    }


    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String, String> login(@RequestBody Map<String, String> request)  {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.get("username"),
                            request.get("password")));
            String username = authentication.getName();
            User user = new User(username,"", List.of());
            String token = jwtUtil.createToken(user);


            Map<String, String> response = Map.of(
                    "username", username,
                    "token", token
            );


            return response;


        } catch (BadCredentialsException e) {
            return Map.of("status", "bad request");
        } catch (Exception e) {
            return Map.of("status", "bad request");
        }
    }
}
