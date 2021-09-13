package Commands;

import Elements.Person;

import java.util.TreeSet;

/**
 * Класс команды которая добавляет элемент в коллекци, если его значение меньше, чем у наименьшего элемента этой коллекции
 */
public class CommandAddIfMin implements Command{
    /**
     * Метод который добавляет элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
     *
     */
    private String command;
    private TreeSet collection;
    public CommandAddIfMin(String command, TreeSet<Person> collection) {
        this.command = command;
        this.collection = collection;
    }
    @Override

    public void action(){
        String[] field;
        Object[] arr;
        String element;
        boolean work;
        work = false;
        int index;
        field = command.split(" ");
        if (field.length == 1){
            System.out.println("\nЭлемент отсутствует\n");
        } else if (field.length >= 2){
            element = field[1];
            if (field.length > 2){
                for (index = 2; index<field.length; index++) {
                    element = element + " " + field[index];
                }
            }
            arr = collection.toArray();
            for (index = 0; index<collection.size(); index++) {
                if (element.hashCode() < arr[index].hashCode()) {
                    CommandAdd commandAdd = new CommandAdd(command, collection);
                    commandAdd.action();
                    work = true;
                    break;
                }
            }
            if (!work) System.out.println("\nЭлемент не является наименьшим\n");
        } else System.out.println("\nНеверный формат ввода данных\n");
    }
}