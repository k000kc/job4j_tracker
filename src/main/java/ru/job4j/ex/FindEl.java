package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] values, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < values.length; index++) {
            if (key.equals(values[index])) {
                rsl = index;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("element not found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] value = {"1", "2", "3", "4", "5"};
        try {
            int index = indexOf(value, "0");
            System.out.println(index);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
