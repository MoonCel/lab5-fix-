package Commands;

import Elements.Person;

import java.util.TreeSet;

/**
 * Класс команды которая удаляет все элементы из коллекции
 */
public class CommandClear implements Command{
    /**
     * Метод который удаляет все элементы из коллекции
     *
     */

    private TreeSet collection;
    public CommandClear(TreeSet<Person> collection) {
        this.collection = collection;
    }
    @Override
    public void action(){
        collection.clear();
        System.out.println("\nКоллекция успешно очищена\n");
    }
}
