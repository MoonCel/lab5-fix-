package Commands;

import Elements.Person;
import java.time.LocalDateTime;
import java.util.TreeSet;
    public class CommandExecution implements Command{
        /**
         * Команда которая исполняет все команды
         *
         * @param collection - коллекция
         * @param line - строка котрую вводят с консоли
         * @param command - комманда котрую вводят с консоли
         * @param file - файл в котором храниться коллекция
         * @param time - текущее время
         */
        private String command;
        private TreeSet<Person> collection;
        private String line;
        private String file;
        private LocalDateTime time;
        public CommandExecution(TreeSet<Person> collection, String line, String command, String file, LocalDateTime time) {
            this.collection = collection;
            this.command = command;
            this.line = line;
            this.file = file;
            this.time = time;

        }
        @Override
        public void action(){
            //System.out.println(line);
            if (line.equals("help")){
                CommandHelp commandHelp = new CommandHelp();
                commandHelp.action();
                //System.out.println("pop");

            } else if (line.equals("info")){
                CommandInfo commandInfo = new CommandInfo(collection, time);
                commandInfo.action();

            } else if (line.equals("show")){
                CommandShow commandShow = new CommandShow(collection);
                commandShow.action();

            } else if (line.equals("exit")){
                CommandExit commandExit = new CommandExit();
                commandExit.action();

            } else if (line.equals("add")){
                CommandAdd commandAdd = new CommandAdd(line, collection);
                commandAdd.action();

            } else if ((command).equals("update_id")){
                CommandUpdateID commandUpdateID = new CommandUpdateID(line, collection);
                commandUpdateID.action();

            } else if ((command).equals("remove_by_id")){
                CommandRemoveByID commandRemoveByID = new CommandRemoveByID(command, collection);
                commandRemoveByID.action();

            } else if ((command).equals("filter_contains_name")){
                if (line.split(" ").length >= 2) {
                    CommandFilterContains commandFilterContains = new CommandFilterContains(line.split(" ")[1], collection);
                    commandFilterContains.action();
                }
            } else if ((command).equals("add_if_min")){
                CommandAddIfMin commandAddIfMin = new CommandAddIfMin(line, collection);
                commandAddIfMin.action();

            } else if ((command).equals("add_if_max")){
                CommandAddIfMax commandAddIfMax = new CommandAddIfMax(line, collection);
                commandAddIfMax.action();

            } else if ((command).equals("remove_greater")){
                CommandRemoveGreater commandRemoveGreater = new CommandRemoveGreater(line, collection);
                commandRemoveGreater.action();

            } else if ((line).equals("clear")){
                CommandClear commandClear = new CommandClear(collection);
                commandClear.action();

            } else if ((line).equals("save")){
                CommandSave commandSave = new CommandSave(file, collection);
                commandSave.action();

            } else if ((command).equals("GroupCountingByLocation")){
                CommandGroupCountingByLocation CommandGroupCountingByLocation = new CommandGroupCountingByLocation(collection);
                CommandGroupCountingByLocation.action();

            } else if ((command).equals("execute_script")) {
                CommandExecuteScript commandExecuteScript = new CommandExecuteScript(collection, line, command, file, time);
                commandExecuteScript.action();
            } else {
                System.out.println("\nНеизвестная команда");
                System.out.println("help : вывести справку по доступным командам\n");
            }
        }
    }
