package command;// Инкапсулирует запрос в объекте

public class Main {
    public static void main(String[] args) {
        Conveyor conveyor = new Conveyor();
        MultiPult multiPult = new MultiPult();
        multiPult.setCommand(0, new ConcreteCommandOnOf(conveyor));
        multiPult.setCommand(1, new ConcreteCommandSpeedChanger(conveyor));;
        multiPult.pressOn(0);
        multiPult.pressOn(1);
        multiPult.pressCancel();
        multiPult.pressCancel();
    }
}

