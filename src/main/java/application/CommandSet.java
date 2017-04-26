package application;

import command.Command;
import command.ConvertCommand;
import command.CreateCommand;
import command.SetCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ercan on 26.04.2017.
 */
public class CommandSet {
    private Map<String, Command> commandMap;

    public CommandSet() {
        commandMap = new HashMap<String, Command>();
        commandMap.put("set", new SetCommand());
        commandMap.put("create", new CreateCommand());
        commandMap.put("convert", new ConvertCommand());
    }

    public void run(String command) {
        String[] parseList = command.split(" ");

        if(commandMap.get(parseList[0]) == null) {
            System.out.println("Komut bulunamadı");
        } else {
            commandMap.get(parseList[0]).execute(parseList);
        }
    }
}
