package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] values, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < values.length; index++) {
            if (values[index] == key) {
                rsl = index;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("element not found");
        }
        return rsl;
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        return true;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (ElementAbuseException  ea) {
            ea.printStackTrace();
        } catch (ElementNotFoundException en) {
            en.printStackTrace();
        }
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
