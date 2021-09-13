package Commands;

import Elements.Person;

import java.time.LocalDateTime;
import java.util.TreeSet;

/**
 * Класс команды которая выводит всю информацию о коллекции
 */
public class CommandInfo implements Command{
    /**
     * Метод который выводит всю информацию о коллекции
     *
     * @param collection - коллекция
     * @param time - время создания коллекции
     */

    private TreeSet<Person> collection;
    private LocalDateTime time;
    public CommandInfo(TreeSet<Person> collection, LocalDateTime time) {
        this.collection = collection;
        this.time = time;
    }
    @Override
    public void action(){
        System.out.println("\nТип коллекции: java.util.TreeSet");
        System.out.println("Дата создания: " + time);
        System.out.println("Структура элемента: {id, name, coordinates.x, coordinates.y, creationDate, " +
                "Height, eyeColor, hairColor, country, location(x), location(y), " +
                "location(z)}");
        System.out.println("Колличество элементов: " + collection.size() + "\n");
    }
}