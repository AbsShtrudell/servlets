package com.shtrudell.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HashPasswordTest {
    @ParameterizedTest
    @DisplayName("Should be equal output when equal input")
    @ValueSource(strings = {"admin", "user", "user2", "1234"})
    public void shouldBeEqual(String password) {
        Assertions.assertAll(
                () -> { Assertions.assertArrayEquals(HashPassword.getHash(password), HashPassword.getHash(password)); },
                () -> { Assertions.assertEquals(HashPassword.getHash(password).length, HashPassword.getHash(password + "fsd").length); }
        );
    }

    @Test
    @DisplayName("Should return null when null input")
    public void nullWhenInputNull() {
        Assertions.assertNull(HashPassword.getHash(null));
    }
}
