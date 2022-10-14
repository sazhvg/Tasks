package behavioral.command;

public class MultiplicationCommand extends Command<Integer, Integer> {

    public MultiplicationCommand(Integer operand) {
        super(operand);
    }

    @Override
    public Integer execute(Integer currentValue) {
        return currentValue * operand;
    }

    @Override
    public Integer undo(Integer currentValue) {
        return currentValue / operand;
    }

    @Override
    public String toString() {
        return "Multiplying by *" + operand;
    }
}
