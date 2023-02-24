package com.junioroffers.infrastructure.security.jwt;

import com.junioroffers.domain.loginandregister.LoginAndRegisterFacade;
import com.junioroffers.domain.loginandregister.dto.UserDto;
import java.util.Collections;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@AllArgsConstructor
public class LoginUserDetailsService implements UserDetailsService {

    private final LoginAndRegisterFacade loginAndRegisterFacade;

    @Override
    public UserDetails loadUserByUsername(String username) throws BadCredentialsException {
        UserDto userDto = loginAndRegisterFacade.findByUsername(username);
        return getUser(userDto);
    }

    private org.springframework.security.core.userdetails.User getUser(UserDto user) {
        return new org.springframework.security.core.userdetails.User(
                user.username(),
                user.password(),
                Collections.emptyList());
    }
}
