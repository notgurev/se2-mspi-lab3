package se.mspi.lab3.commands;

import se.mspi.lab3.ShootingRangeSimulator;

public class ExitCommand extends Command{
    public ExitCommand() {
        super("exit", "- выйти из программы");
    }

    @Override
    public void execute(String args, ShootingRangeSimulator shootingRangeSimulator) {
        System.exit(0);
    }
}
