package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitProgram(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replaceName = "New item name";
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0", id, replaceName, "1"}
        );
        Output output = new StubOutput();
        UserAction[] actions = {
                new ReplaceItem(output),
                new ExitProgram(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replaceName);
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        String id = String.valueOf(item.getId());
        Input input = new StubInput(
                new String[]{"0", id, "1"}
        );
        Output output = new StubOutput();
        UserAction[] actions = {
                new DeleteItem(output),
                new ExitProgram(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitProgram(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu:" + System.lineSeparator()
                + "0. Exit Program" + System.lineSeparator()
        );
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfuly() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        UserAction[] actions = new UserAction[] {
                new ReplaceItem(out),
                new ExitProgram(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                + "0. Edit item" + ln
                + "1. Exit Program" + ln
                + "=== Edit item ===" + ln
                + "Заявка изменена успешно." + ln
                + "Menu:" + ln
                + "0. Edit item" + ln
                + "1. Exit Program" + ln
        );
    }

    @Test
    public void whenShowItemsTestOutputItems() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = new UserAction[] {
                new ShowItems(out),
                new ExitProgram(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                + "0. Show all items" + ln
                + "1. Exit Program" + ln
                + "=== Show all items ===" + ln
                + one + ln + two + ln
                + "Menu:" + ln
                + "0. Show all items" + ln
                + "1. Exit Program" + ln
        );
    }

    @Test
    public void whenFindByIdItemTestOutputItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), "1"}
        );
        UserAction[] actions = new UserAction[] {
                new FindById(out),
                new ExitProgram(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                + "0. Find item by id" + ln
                + "1. Exit Program" + ln
                + "=== Find item by id ===" + ln
                + one + ln
                + "Menu:" + ln
                + "0. Find item by id" + ln
                + "1. Exit Program" + ln
        );
    }

    @Test
    public void whebFindByNameItemsTestOutputItems() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(two.getName()), "1"}
        );
        UserAction[] actions = new UserAction[] {
                new FindByName(out),
                new ExitProgram(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                + "0. Find items by name" + ln
                + "1. Exit Program" + ln
                + "=== Find items by name ===" + ln
                + two + ln
                + "Menu:" + ln
                + "0. Find items by name" + ln
                + "1. Exit Program" + ln
        );
    }
}