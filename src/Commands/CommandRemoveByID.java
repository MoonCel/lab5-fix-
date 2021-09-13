package Commands;

import Elements.Person;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Класс команды которая удаляет все элементы с указанным id
 */
public class CommandRemoveByID implements Command{
    /**
     * Метод который удаляет все элементы с указанным id
     *
     * @param command - команда которую вводят с консоли
     * @param collection - коллекция
     */

    private TreeSet<Person> collection;
    private String command;
    public CommandRemoveByID(String command, TreeSet<Person> collection) {
        this.collection = collection;
        this.command = command;

    }
    @Override
    public void action(){
        String[] fields;
        Object[] arr;
        boolean work;
        work = false;
        int index;
        String id;
        fields = command.split(" ");
        if (fields.length == 2){
            arr = collection.toArray();
            for (index = 0; index<collection.size(); index++){
                //id = (arr[index].toString()).split(",");
                id = ((Person) arr[index]).getId().toString();
                if (id.equals(fields[1])){
                    collection.remove((arr[index]));
                    System.out.println("\nЭлемент успешно удалён\n");
                    work = true;
                }
            }
        } else {
            System.out.println("\nНеверный формат ввода данных\n");
            work = false;
        }
        if (!work) System.out.println("\nНе найдено элемента с таким id\n");
    }
}
