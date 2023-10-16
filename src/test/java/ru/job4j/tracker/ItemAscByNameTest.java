package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {
    @Test
    public void whenSortedByName() {
        List<Item> items = new ArrayList<>();
        Item a = new Item("aaa");
        Item b = new Item("bbb");
        Item c = new Item("ccc");
        items.add(c);
        items.add(a);
        items.add(b);
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(a, b, c);
        assertThat(items).isEqualTo(expected);
    }

}