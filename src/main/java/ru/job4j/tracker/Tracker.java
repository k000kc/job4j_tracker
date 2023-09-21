package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[items.length];
        int rslSize = 0;
        for (int i = 0; i < size; i++) {
            if (items[i] != null && key.equals(items[i].getName())) {
                rsl[rslSize] = items[i];
                rslSize++;
            }
        }
        return Arrays.copyOf(rsl, rslSize);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            int oldId = items[index].getId();
            items[index] = item;
            items[index].setId(oldId);
            return true;
        }
        return false;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
        }
    }
}