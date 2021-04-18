package se.mspi.lab3;

import se.mspi.lab3.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShootingRangeSimulator {
    Map<String, Command> commandMap = new HashMap<>();

    public ShootingRangeSimulator() {
        addCommands(
                new ExitCommand(),
                new HelpCommand(),
                new HistoryCommand(),
                new ShotCommand()
        );
    }

    private void addCommands(Command... commands) {
        for (Command command : commands) {
            commandMap.put(command.getName(), command);
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String input;
        //noinspection InfiniteLoopStatement
        while (true) {
            System.out.print("> ");
            input = scanner.next();
            if (input.trim().length() == 0) continue;
            parseAndExecute(input.trim());
        }
    }

    public void parseAndExecute(String input) {
        String[] s = input.split(" ");
        String key = s[0];
        String args = input.substring(s[0].length());
        Command command = commandMap.get(key);
        if (command != null) command.execute(args);
        else System.out.println("Такой команды нет, список команд: help");
    }
}
