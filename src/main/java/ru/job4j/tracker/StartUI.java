package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;

import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
//        Store tracker = new SqlTracker();
        Store tracker = new MemTracker();
//        List<UserAction> actions = List.of(
//                new CreateAction(output),
//                new ShowItems(output),
//                new ReplaceItem(output),
//                new DeleteItem(output),
//                new FindById(output),
//                new FindByName(output),
//                new ExitProgram(output));
        List<UserAction> actions = List.of(
                new CreateManyItems(output),
                new ShowItems(output),
                new DeleteAllItems(output),
                new ExitProgram(output)
        );
        new StartUI(output).init(input, tracker, actions);

    }
}
