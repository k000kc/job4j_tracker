package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void when() {
        Citizen citizen = new Citizen("1234", "Test Testov");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        boolean result = office.add(
                new Citizen("1234", "Update Updateov")
        );
        assertThat(result).isFalse();
    }
}