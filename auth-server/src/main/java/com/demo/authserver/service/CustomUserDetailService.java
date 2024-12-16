package com.demo.authserver.service;


import com.demo.authserver.entity.UserEntity;
import com.demo.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByName(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));

        return new User(userEntity.getName(), userEntity.getPassword(),
                Arrays.stream(userEntity.getRole().split("\\|"))
                        .map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    }
}
