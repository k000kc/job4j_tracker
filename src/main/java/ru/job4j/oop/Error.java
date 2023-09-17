package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printError() {
        System.out.println("Наличие ошибки: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printError();
        Error error1 = new Error(true, 1, "Ошибка 1");
        error1.printError();
        Error error2 = new Error(false, 0, "Нет ошибки");
        error2.printError();
    }
}
