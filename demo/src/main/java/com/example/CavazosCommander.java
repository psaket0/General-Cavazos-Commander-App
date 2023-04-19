package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {

    private static final List<String> COMMANDS = List.of(
            "About Face", "Change Step", "Close Ranks", "Column Right", "Count Off", "Cover", "Eyes Right",
            "Fall In", "Fall Out", "Flight Attention", "Flight Halt", "Forward March", "Left Face", "Left Flank",
            "Open Ranks", "Order Arms", "Parade Rest", "Present Arms", "Present Arms  ", "Ready Front",
            "Report In", "Report Out", "Right Face", "Right Flank", "Right Step, March", "To the Rear, March");

    private List<String> commands = new ArrayList<>();
    private List<String> undone = new ArrayList<>();
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        App commander = new App();
        commander.run();
    }

    private void run() {
        while (true) {
            System.out.println("--------General Cavazos Commander App------------");
            System.out.println("i      issue a command");
            System.out.println("l      list commands");
            System.out.println("u      undo last command");
            System.out.println("r      redo last command");
            System.out.println("q      quit");
            System.out.println("-------------------------------------------------");
            System.out.print("Enter a command: ");
            String command = scanner.nextLine();
            switch (command) {
                case "i":
                    System.out.println("Issuing command...");
                    System.out.println(issueCommand());
                    break;
                case "l":
                    System.out.println("Listing commands...");
                    listCommands();
                    break;
                case "u":
                    System.out.println("Undoing last command...");
                    undoCommand();
                    break;
                case "r":
                    System.out.println("Redoing last command...");
                    redoCommand();
                    break;
                case "q":
                    System.out.println("Quitting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command: " + command);
            }
        }
    }

    private String issueCommand() {
        String command = COMMANDS.get(random.nextInt(COMMANDS.size()));
        commands.add(command);
        return command;
    }

    private void listCommands() {
        for (int i = 0; i < commands.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, commands.get(i));
        }
    }

    private void undoCommand() {
        if (!commands.isEmpty()) {
            String command = commands.remove(commands.size() - 1);
            undone.add(command);
            System.out.println("Undid command: " + command);
        } else {
            System.out.println("No commands to undo");
        }
    }

    private void redoCommand() {
        if (!undone.isEmpty()) {
            String command = undone.remove(undone.size() - 1);
            commands.add(command);
            System.out.println("Redid command: " + command);
        } else {
            System.out.println("No commands to redo");
        }
    }
}
