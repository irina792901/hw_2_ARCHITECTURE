package command;

public class ConcreteCommandOnOf implements Command{
    private Conveyor conveyor;
    public ConcreteCommandOnOf(Conveyor conveyor) {
        this.conveyor = conveyor;
    }

    @Override
    public void positive() {
        conveyor.on();
    }

    @Override
    public void negative() {
        conveyor.off();
    }
}
