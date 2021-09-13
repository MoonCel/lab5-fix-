package Commands;
import Manager.Manager;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Класс команды которая добавляет новый элемент в коллекцию
 */
public class CommandAdd implements Command {
    private String command;
    private TreeSet collection;
    public CommandAdd(String command, TreeSet collection) {
        this.command = command;
        this.collection = collection;
    }
    /**
     * Метод который добавляет новый элемент в коллекцию
     *
     */
    @Override
    public void action() {
        Manager manager = new Manager();
        Scanner in = new Scanner(System.in);
        StringBuilder element = new StringBuilder("");
        String field[] = new String[]{
                //"Id: ",
                "Name: ",
                "X: ",
                "Y: ",
                //"CreationDate: ",
                "Height: ",
                "EyeColor (BLUE, GREEN, RED, ORANGE, BROWN): ",
                "HairColor (BLUE, GREEN, RED, ORANGE, BROWN): ",
                "Country (FRANCE, CHINA, INDIA): ",
                "x: ",
                "y: ",
                "z: "
        } ;
        for (int i = 0; i<field.length; i++){
            System.out.print(field[i]);
            element.append(",");
            element.append(in.nextLine());
        }
        String braum = element.substring(1);

        manager.add(braum, collection, false, 0);


    }
}