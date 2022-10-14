package behavioral.command;

public class AdditionCommand extends Command<Integer, Integer> {

    public AdditionCommand(Integer operand) {
        super(operand);
    }

    @Override
    public Integer execute(Integer currentValue) {
        return currentValue + operand;
    }

    @Override
    public Integer undo(Integer currentValue) {
        return currentValue - operand;
    }

    @Override
    public String toString() {
        return "Adding +" + operand;
    }
}
