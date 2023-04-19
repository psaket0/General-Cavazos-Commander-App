package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.Scanner;

public class CavazosCommander {
    private static final List<String> COMMANDS = Arrays.asList(
            "About Face", "Change Step", "Close Ranks", "Column Right", "Count Off", "Cover", "Eyes Right",
            "Fall In", "Fall Out", "Flight Attention", "Flight Halt", "Forward March", "Left Face", "Left Flank",
            "Open Ranks", "Order Arms", "Parade Rest", "Present Arms", "Present Arms  ", "Ready Front",
            "Report In", "Report Out", "Right Face", "Right Flank", "Right Step, March", "To the Rear, March");

    private static final Random random = new Random();
    private static final Stack<String> commandHistory = new Stack<>();
    private static final Stack<String> redoHistory = new Stack<>();

    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------\n");
        System.out.println("General Cavazos Commander App\n");
        System.out.println("-----------------------------------------------------\n");
        printMenu();
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.print("Enter a command: ");
            input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "i":
                    String command = COMMANDS.get(random.nextInt(COMMANDS.size()));
                    System.out.println("Issuing command: " + command);
                    commandHistory.push(command);
                    break;
                case "l":
                    System.out.println("List of commands:");
                    for (String c : COMMANDS) {
                        System.out.println("- " + c);
                    }
                    break;
                case "u":
                    if (!commandHistory.isEmpty()) {
                        String lastCommand = commandHistory.pop();
                        redoHistory.push(lastCommand);
                        System.out.println("Undoing command: " + lastCommand);
                    } else {
                        System.out.println("No commands to undo.");
                    }
                    break;
                case "r":
                    if (!redoHistory.isEmpty()) {
                        String lastUndoneCommand = redoHistory.pop();
                        commandHistory.push(lastUndoneCommand);
                        System.out.println("Redoing command: " + lastUndoneCommand);
                    } else {
                        System.out.println("No commands to redo.");
                    }
                    break;
                case "q":
                    System.out.println("Quitting...");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        } while (!input.equals("q"));
    }

    private static void printMenu() {
        System.out.println("i - issue a command");
        System.out.println("l - list all commands");
        System.out.println("u - undo last command");
        System.out.println("r - redo last command");
        System.out.println("q - quit");
        System.out.println("-----------------------------------------------------\n");
        System.out.println();
    }
}