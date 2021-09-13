package Commands;
import Elements.Person;

import java.util.TreeSet;

/**
 * Класс команды который выводит элементы, значение поля name которых содержит заданную подстроку
 */
public class CommandFilterContains implements Command {
    /**
     * Метод который выводит элементы, значение поля name которых содержит заданную подстроку
     *
     */
    private String line;
    private TreeSet<Person> collection;
    public CommandFilterContains(String line, TreeSet<Person> collection) {
        this.line = line;
        this.collection = collection;
    }
    @Override
    public void action(){
        Person[] arr;
        arr = collection.toArray(new Person[0]);
        for (int i =0; i < collection.size(); i++){
            if (i == 0) {
                show(arr[i], line);
            } else if (i == collection.size()-1) {
                show(arr[i], line);
            } else show(arr[i], line);
        }
    }
    private void show(Person person,String line){
        if (person.getName().contains(line)) {

            System.out.println("id: " + person.getId());
            System.out.println("Name: " + person.getName());
            System.out.println("Coordinates: " + person.getCoordinates().getX());
            System.out.println("Coordinates: " + person.getCoordinates().getY());
            System.out.println("Country: " + person.getCountry());
            System.out.println("CreationDate: " + person.getCreationDate());
            System.out.println("EyeColor: " + person.getEyeColor().toString());
            System.out.println("HairColor: " + person.getHairColor().toString());
            System.out.println("Height: " + person.getHeight());
            System.out.println("\tLocation X: " + person.getLocation().getXloc());
            System.out.println("\tLocation Y: " + person.getLocation().getYloc());
            System.out.println("\tLocation Z: " + person.getLocation().getZloc());
            System.out.println(person.getLocation());
        }
    }
}
