package org.wrabz.sec;

import org.jspecify.annotations.Nullable;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PlainTextPasswordEncoder implements PasswordEncoder {
    //We return the password as it is
    @Override
    public @Nullable String encode(@Nullable CharSequence rawPassword) {
        return  rawPassword.toString();
    }

    //Checks if two strings are equal
    @Override
    public boolean matches(@Nullable CharSequence rawPassword, @Nullable String encodedPassword) {
        return rawPassword.equals(encodedPassword);
    }
}