package ru.job4j.condition;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxTest {

    @Test
    void when1and2Then2() {
        int first = 1;
        int second = 2;
        Max max = new Max();
        int result = max.max(first, second);
        int expected = 2;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void when1and2and3Then3() {
        int first = 1;
        int second = 2;
        int third = 3;
        Max max = new Max();
        int result = max.max(first, second, third);
        int expected = 3;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void when1and2and3and4Then4() {
        int first = 2;
        int second = 4;
        int third = 3;
        int fourth = 1;
        Max max = new Max();
        int result = max.max(first, second, third, fourth);
        int expected = 4;
        assertThat(result).isEqualTo(expected);
    }
}