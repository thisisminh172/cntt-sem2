package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\t | Menu:          \t\t|");
            System.out.println("\t | 1. LineSegment \t\t|");
            System.out.println("\t | 2. Triangle    \t\t|");
            System.out.println("\t | 3. Rectangle   \t\t|");
            System.out.println("\t | 4. Circle      \t\t|");
            System.out.println("\t | 5. Cancel      \t\t|");
            System.out.print(">>>>> Enter your choice[1-5]: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(">You selected LineSegment.");
                    LineSegment ls = new LineSegment();
                    break;
                case 2:
                    System.out.println(">You selected Triangle.");
                    Triangle tr = new Triangle();
                    break;
                case 3:
                    System.out.println(">You selected Rectangle.");
                    Rectangle re = new Rectangle();
                    break;
                case 4:
                    System.out.println(">You selected Circle.");
                    Circle ci = new Circle();
                    break;
                case 5:
                    System.out.println(">Program terminated.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }
}