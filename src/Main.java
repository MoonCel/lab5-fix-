import Commands.*;
import Elements.Person;
import Manager.Manager;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.TreeSet;
import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        //String temp = System.getenv().get("PersonPATH");
        Manager manager = new Manager();
        TreeSet<Person> collection = new TreeSet<Person>(new PersonComparator());
        LocalDateTime today = LocalDateTime.now();
        String file;
        //file = "/home/s308489/Person.csv";
        while (true){
            try {
                System.out.print("Путь к файлу: ");
                Scanner scanner = new Scanner(System.in);
                file = scanner.nextLine();
                manager.fill(file, collection);
                break;
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден");
            }
        }
        System.out.println("\nhelp : вывести справку по доступным командам\n");

        while (true){
            System.out.println("Введите команду:");
            String line;
            String command;
            line = in.nextLine();
            String[] field;
            field = line.split(" ");
            command = field[0];
            CommandExecution commandExecution = new CommandExecution(collection, line, command, file, today);
            commandExecution.action();
        }
    }
}