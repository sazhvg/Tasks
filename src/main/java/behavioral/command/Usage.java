package behavioral.command;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Usage {
    private int currentValue = 0;

    public void runSomeTestCommands() {
        List<Command<Integer, Integer>> operations = List.of(
                new AdditionCommand(2),
                new SubtractionCommand(3),
                new MultiplicationCommand(2),
                new AdditionCommand(5));
        runCommandsWithOutput(operations, cmd -> currentValue = cmd.executeVerbose(currentValue));

        List<Command<Integer, Integer>> undoList = new LinkedList<>(operations.subList(operations.size() - 2, operations.size()));
        Collections.reverse(undoList);
        runCommandsWithOutput(undoList, cmd -> currentValue = cmd.undoVerbose(currentValue));
    }

    private void runCommandsWithOutput(List<Command<Integer, Integer>> operations,
            Function<Command<Integer, Integer>, Integer> consumer) {
        System.out.println("Starting with: " + currentValue);
        operations.forEach(consumer::apply);
        System.out.println("Current result: " + currentValue);
        System.out.println("=====");
    }

    public static void main(String[] args) {
        new Usage().runSomeTestCommands();
    }
}
