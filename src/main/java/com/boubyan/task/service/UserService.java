package com.boubyan.task.service;

import com.boubyan.task.config.security.AuthUtil;
import com.boubyan.task.config.security.SecurityUtil;
import com.boubyan.task.model.dto.LoginResponseDTO;
import com.boubyan.task.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SecurityUtil securityUtil;
    private final AuthUtil authUtil;

    @SneakyThrows
    public LoginResponseDTO login(String username, String password) {
        var user = userRepository.findByUsername(username);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new AuthenticationException("Username or password is incorrect");
        }

        String jwt = securityUtil.generateJwtToken(authUtil.authenticate(username,password));
        return LoginResponseDTO.builder()
                .name(user.getName())
                .username(user.getUsername())
                .token(jwt)
                .build();
    }
}
