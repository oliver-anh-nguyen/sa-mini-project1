package edu.miu.sa.miniproject1.controller;

import edu.miu.sa.miniproject1.dto.LoginDto;
import edu.miu.sa.miniproject1.dto.LoginResponse;
import edu.miu.sa.miniproject1.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public Mono<LoginResponse> login(@RequestBody LoginDto loginDto) {
        return Mono.fromSupplier(() -> loginService.login(loginDto));
    }

}
