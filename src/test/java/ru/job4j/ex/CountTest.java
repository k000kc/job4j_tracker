package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CountTest {

    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Count.add(10, 2));
        assertThat(exception.getMessage()).isEqualTo("Start should be less than finish.");
    }

    @Test
    public void whenSumFrom2To10Then44() {
        int start = 2;
        int finish = 10;
        int result = Count.add(start, finish);
        int expected = 44;
        assertThat(result).isEqualTo(expected);
    }
}