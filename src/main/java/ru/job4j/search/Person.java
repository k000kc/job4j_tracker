package ru.job4j.search;

public class Person {
    private String name;
    private String surname;
    private String phone;
    private String addrwss;

    public Person(String name, String surname, String phone, String addrss) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.addrwss = addrss;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddrwss() {
        return addrwss;
    }
}
