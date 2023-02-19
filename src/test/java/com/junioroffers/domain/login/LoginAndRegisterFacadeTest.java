package com.junioroffers.domain.login;

import com.junioroffers.domain.login.dto.RegisterUserDto;
import com.junioroffers.domain.login.dto.RegistrationResultDto;
import com.junioroffers.domain.login.dto.UserDto;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LoginAndRegisterFacadeTest {

    LoginAndRegisterFacade loginFacade = new LoginAndRegisterFacade(
            new InMemoryLoginRepository()
    );

    @Test
    public void should_register_user() {
        // given
        RegisterUserDto registerUserDto = new RegisterUserDto("username", "pass");

        // when
        RegistrationResultDto register = loginFacade.register(registerUserDto);

        // then
        assertAll(
                () -> assertThat(register.created()).isTrue(),
                () -> assertThat(register.username()).isEqualTo("username")
        );
    }

    @Test
    public void should_find_user_by_user_name() {
        // given
        RegisterUserDto registerUserDto = new RegisterUserDto("username", "pass");
        RegistrationResultDto register = loginFacade.register(registerUserDto);

        // when
        UserDto userByName = loginFacade.findByUsername(register.username());

        // then
        assertThat(userByName).isEqualTo(new UserDto(register.id(), "pass", "username"));
    }

    @Test
    public void should_throw_exception_when_user_not_found() {
        // given
        String username = "someUser";

        // when
        Throwable thrown = catchThrowable(() -> loginFacade.findByUsername(username));

        // then
        AssertionsForClassTypes.assertThat(thrown)
                .isInstanceOf(UsernameNotFoundException.class)
                .hasMessage("User not found");
    }
}
