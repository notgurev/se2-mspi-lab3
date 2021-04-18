package se.mspi.lab3.commands;

import se.mspi.lab3.ShootingRangeSimulator;

public abstract class Command {
    protected final String name;
    protected final String helpText;

    public Command(String name, String helpText) {
        this.name = name;
        this.helpText = helpText;
    }

    public abstract void execute(String args, ShootingRangeSimulator shootingRangeSimulator);

    public String getFullHelpLine() {
        return name + " " + helpText;
    }

    public String getName() {
        return name;
    }

    public String getHelpText() {
        return helpText;
    }
}
