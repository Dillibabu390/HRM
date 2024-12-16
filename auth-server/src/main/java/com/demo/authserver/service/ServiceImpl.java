package com.demo.authserver.service;
import com.demo.authserver.entity.UserEntity;
import com.demo.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service public class ServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtEncoder jwtEncoder;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(UserEntity user){
        Optional<UserEntity> userEntity = userRepository.findByName(user.getName());
        if (userEntity.isPresent()){
            return "Username already taken";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_EMP");
        user.setId(UUID.randomUUID().toString().split("-")[0]);
        userRepository.save(user);

        return "User Registered successfully";
    }

    public Map<String, Object> login(String username, String password) {
        Optional<UserEntity> userEntity = userRepository.findByName(username);
        Map<String, Object> response = new HashMap<>();

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        if (!userEntity.isPresent()){
            response.put("status", "User Not Found");
            return response;
        }
        String accessToken = generateToken(userEntity.get(), authentication, 3600);
        response.put("access_token", accessToken);
        response.put("expires_in", 3600);
        return response;
    }

    private String generateToken(UserEntity userEntity, Authentication authentication, long expiryDuration){
        Instant now = Instant.now();
        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
                .issuer("Dilli babu")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiryDuration))
                .subject(authentication.getName())
                .claim("role", authentication.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toSet()))
                .claim("Name", userEntity.getName())
                /*.claim("firstName", userEntity.getFirstName())
                .claim("lastName", userEntity.getLastName())*/
                .claim("userId", userEntity.getId())
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();

    }
}
