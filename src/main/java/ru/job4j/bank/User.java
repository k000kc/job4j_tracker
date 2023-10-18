package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс представляет клиента банка
 * @author Petrov Andrey
 * @version 1.0
 */
public class User {
    /**
     * Данные паспорта клиента
     */
    private String passport;
    /**
     * Имя пользователя
     */
    private String username;

    /**
     * Конструктор
     * @param passport Данные паспорта клиента
     * @param username Имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Getter паспорта
     * @return Данные паспорта клиента
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Setter паспорта
     * @param passport Данные паспорта клиента
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Getter имени пользователя
     * @return Имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter имени пользователя
     * @param username Имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределение метода equals()
     * @param o иной экземпляр класса User
     * @return true если User равны,
     *         false если User не равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределение метода hashCode()
     * @return хэш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
