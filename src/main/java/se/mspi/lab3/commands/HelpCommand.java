package se.mspi.lab3.commands;

import se.mspi.lab3.ShootingRangeSimulator;

import java.util.Map;

public class HelpCommand extends Command {
    public HelpCommand() {
        super("help", "- справка по командам программы");
    }

    @Override
    public void execute(String args, ShootingRangeSimulator shootingRangeSimulator) {
        Map<String, Command> commandMap = shootingRangeSimulator.getCommandMap();
        System.out.println("Команды:");
        int index = 1;
        for (Map.Entry<String, Command> entry : commandMap.entrySet()) {
            System.out.println((index++) + ". " + entry.getValue().getFullHelpLine());
        }
    }
}
