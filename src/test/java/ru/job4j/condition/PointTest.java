package ru.job4j.condition;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PointTest {

    @Test
    void whenA00ToB02Then2Dot0() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double result = a.distance(b);
        double expected = 2.0;
        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenA13ToB43Then3() {
        Point a = new Point(1, 3);
        Point b = new Point(4, 3);
        double result = a.distance(b);
        double expected = 3.0;
        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenA000ToB333Then5Dot2() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(3, 3, 3);
        double result = a.distance3d(b);
        double expected = 5.2;
        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }
}