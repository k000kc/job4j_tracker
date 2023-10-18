package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс представляет модель банковского счета
 * @author Petrov Andrey
 * @version 1.0
 */
public class Account {
    /**
     * Реквизиты банковского счета
     */
    private String requisite;
    /**
     * Баланс на счете
     */
    private double balance;

    /**
     * Конструктор
     * @param requisite реквизит
     * @param balance баланс
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Getter поля реквизит
     * @return значение реквизита
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Setter поля реквизит
     * @param requisite значение реквизита
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Getter поля баланс
     * @return значение баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Setter поля баланс
     * @param balance значение баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределение метода equals()
     * @param o иной экземпляр класса Account
     * @return true если Account равны,
     *         false если Account не равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределение метода hashCode()
     * @return хэш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
