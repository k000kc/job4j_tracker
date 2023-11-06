package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> checkName = (x) -> x.getName().contains(key);
        Predicate<Person> checkSurname = (x) -> x.getSurname().contains(key);
        Predicate<Person> checkPhone = (x) -> x.getPhone().contains(key);
        Predicate<Person> checkAddress = (x) -> x.getAddrss().contains(key);
        var combine = checkName.or(checkSurname).or(checkPhone).or(checkAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
