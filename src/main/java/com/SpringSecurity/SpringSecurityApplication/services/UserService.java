package com.SpringSecurity.SpringSecurityApplication.services;

import com.SpringSecurity.SpringSecurityApplication.dto.SignUpDto;
import com.SpringSecurity.SpringSecurityApplication.dto.UserDto;
import com.SpringSecurity.SpringSecurityApplication.entities.User;
import com.SpringSecurity.SpringSecurityApplication.exceptions.ResourceNotFoundException;
import com.SpringSecurity.SpringSecurityApplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(username)
                .orElseThrow(() ->new BadCredentialsException("Username with username " + username + "not found"));
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() ->new ResourceNotFoundException("User with id " + userId + "not found"));
    }

}
