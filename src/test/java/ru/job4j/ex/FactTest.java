package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FactTest {

    @Test
    public void whenExeptiom() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Fact().calc(-1));
        assertThat(exception.getMessage()).isEqualTo("N could not be less than 0");
    }

    @Test
    public void whenN4ThenResult24() {
        int input = 4;
        int result = new Fact().calc(input);
        int expected = 24;
        assertThat(result).isEqualTo(expected);
    }
}