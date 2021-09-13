package Commands;

/**
 * Класс команды которая завершает работу программы
 */
public class CommandExit implements Command{
    /**
     * Метод который завершает работу программы
     */
    @Override
    public void action(){
        System.exit(0);
    }
}