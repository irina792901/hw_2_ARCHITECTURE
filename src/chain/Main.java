package chain;
/* Цель - связывыание объектов-обработчиков в цепочку
и передача запроса на ней
*/
class Level{
    public static final int ERROR = 3;
    public static final int DEBUG = 2;
    public static final int INFO = 1;
}

abstract class Logger{
    private int priority;
    private Logger next;

    public Logger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next) {
        this.next = next;
    }
    public void writeMessage(String message, int level) {
        if (level>=priority) write(message);
        if (next !=  null) next.writeMessage(message, level);
    }
    abstract void write(String message);
}

class SMSLogger extends Logger {
    public SMSLogger(int priority) {
        super(priority);}
    @Override
    public void write(String message) {
        System.out.println("SMS: " + message);
    }
}

class FileLogger extends Logger {
    public FileLogger(int priority) {
        super(priority);
    }
    @Override
    public void write(String message) {
        System.out.println("Write in file: " + message);
    }
}
class EmailLogger extends Logger {
    public EmailLogger(int priority) {
        super(priority);
    }
    @Override
    public void write(String message) {
        System.out.println("The letter was send " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        Logger smsLogger = new SMSLogger(Level.INFO);
        Logger fileLogger = new FileLogger(Level.DEBUG);
        Logger emailLogger = new EmailLogger(Level.ERROR);
        smsLogger.setNext(fileLogger);
        fileLogger.setNext(emailLogger);
        smsLogger.writeMessage("Hiuston, we have a problem", Level.ERROR);
    }
}
