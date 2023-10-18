package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс представляет банковский сервис по обслуживанию клиентов банка
 * @author Petrov Andrey
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных клиентов и их счетов осуществлено при помощи HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет клиента в банковскую систему,
     * если такой клиент уже существует в системе,
     * тогда хранилище остается без изменений
     * @param user клиент которого хотим добавить в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет удалить клиента из банковской системы
     * по данным его паспорта
     * @param passport данные паспорта по которым будет удален клиент
     * из банковсой системы
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод позволяет добавить новый счет для клиента банка.
     * Если данный клиент найден в системе,
     * и у него нет точно такого же счета,
     * тогда новый счет будет создан
     * @param passport паспортные данные клиента
     * @param account банковский счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод позволяет найти клиента банка по паспорту
     * @param passport паспорт клиента банка
     * @return если клиент найдет, вернется User,
     * иначе вернется null
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод позволяет найти счет клиента банка по реквизитам.
     * Если данный пользователь и счет имеются в системе,
     * тогда возвращается найденный Account, иначе null
     * @param passport паспорт клиента
     * @param requisite реквизиты счета
     * @return банковский счет
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (requisite.equals(account.getRequisite())) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод предназначен для перевода денег с одного счета на другой.
     * Если переданне в параметрах счета существуют и на счету источника
     * достаточно баланса для перевода на счет назначения,
     * тогда перевод денег осуществляется, иначе нет
     * @param srcPassport паспортные данные счета источника
     * @param srcRequisite реквизиты счета источника
     * @param destPassport паспортные данные счета назначения
     * @param dstRequisite реквизиты счета назначения
     * @param amount баланс
     * @return true если перевод совершен, иначе false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dstRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account desc = findByRequisite(destPassport, dstRequisite);
        if (src != null && desc != null && src.getBalance() >= amount) {
            src.setBalance(src.getBalance() - amount);
            desc.setBalance(desc.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод возвращает список всех счетов клиента банка
     * @param user клиент банка
     * @return список всех счетов клиента
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
