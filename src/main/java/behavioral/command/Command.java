package behavioral.command;

public abstract class Command<V, R> {

    protected V operand;

    public Command(V operand) {
        this.operand = operand;
    }

    public R executeVerbose(V currentValue) {
        System.out.println(this);
        return execute(currentValue);
    }

    public R undoVerbose(V currentValue) {
        System.out.println("[UNDO] " + this);
        return undo(currentValue);
    }

    public abstract R execute(V currentValue);

    public abstract R undo(V currentValue);
}
