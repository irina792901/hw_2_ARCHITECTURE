package command;

public class ConcreteCommandSpeedChanger implements Command{
    private Conveyor converyor;

    public ConcreteCommandSpeedChanger(Conveyor converyor) {
        this.converyor = converyor;
    }

    @Override
    public void positive() {
        converyor.speedIncrease();
    }

    @Override
    public void negative() {
        converyor.speedDecrease();
    }
}
