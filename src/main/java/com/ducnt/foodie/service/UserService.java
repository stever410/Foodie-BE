package com.ducnt.foodie.service;

import com.ducnt.foodie.constants.UserRole;
import com.ducnt.foodie.dto.MessageResponse;
import com.ducnt.foodie.dto.SignupRequest;
import com.ducnt.foodie.model.Role;
import com.ducnt.foodie.model.User;
import com.ducnt.foodie.repository.RoleRepository;
import com.ducnt.foodie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    UserRepository userRepository;
    RoleRepository roleRepository;
    PasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    public MessageResponse addNewUser(@Valid SignupRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email existed");
        }
        User user = new User(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                encoder.encode(request.getPassword())
        );
        Set<Role> roles = new HashSet<>();
        if(request.getRoles() == null || request.getRoles().isEmpty()) {
            Role userRole = roleRepository.findByName(UserRole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException(("Role not found")));
            roles.add(userRole);
        } else {
            request.getRoles().forEach(role -> {
                if(role.equals("admin")) {
                    Role adminRole = roleRepository.findByName(UserRole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException(("Role not found")));
                    roles.add(adminRole);
                }
                if(role.equals("user")) {
                    Role userRole = roleRepository.findByName(UserRole.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException(("Role not found")));
                    roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);
        return new MessageResponse("User registered successfully");
    }
}
