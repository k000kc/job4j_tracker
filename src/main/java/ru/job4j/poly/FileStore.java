package ru.job4j.poly;

public class FileStore implements Store {
    private String path;

    public FileStore() {
    }

    public FileStore(String path) {
        this.path = path;
    }

    public void save(String data) {
        System.out.println("сохраняем данные");
    }

    public String read() {
        System.out.println("читаем данные");
        return null;
    }
}
