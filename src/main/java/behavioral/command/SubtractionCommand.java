package behavioral.command;

public class SubtractionCommand extends Command<Integer, Integer> {

    public SubtractionCommand(Integer operand) {
        super(operand);
    }

    @Override
    public Integer execute(Integer currentValue) {
        return currentValue - operand;
    }

    @Override
    public Integer undo(Integer currentValue) {
        return currentValue + operand;
    }

    @Override
    public String toString() {
        return "Subtracting -" + operand;
    }
}
