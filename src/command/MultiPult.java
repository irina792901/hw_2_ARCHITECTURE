package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MultiPult {
    private List<Command> commands;
    private Stack<Command> history;
    public MultiPult(){
        commands = new ArrayList<Command>();
        commands.add(null);
        commands.add(null);
        history = new Stack<>();
    }
    public void setCommand(int button, Command command){
        commands.set(button, command);
    }
    public void pressOn(int button){
        commands.get(button).positive();
        history.push(commands.get(button));
    }
    public void pressCancel(){
        if (!history.empty()) {
            history.pop().negative();
        }
    }
}
