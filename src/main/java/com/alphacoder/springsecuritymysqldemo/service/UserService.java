package com.alphacoder.springsecuritymysqldemo.service;

import com.alphacoder.springsecuritymysqldemo.domain.security.SecurityUser;
import com.alphacoder.springsecuritymysqldemo.entity.UserEntity;
import com.alphacoder.springsecuritymysqldemo.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor(onConstructor = @__ ({@Autowired}))
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        Optional<UserEntity> userEntityOption= userRepository.findUserByUsername(username);

        UserEntity userEntity= userEntityOption.orElseThrow(() -> new UsernameNotFoundException("User not found."));

        return new SecurityUser(userEntity);
    }
}
