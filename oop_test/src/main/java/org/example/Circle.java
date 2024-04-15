/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.util.Scanner;

/**
 *
 * @author minh-user
 */
public class Circle extends Geometry {

    private Point c;
    private double r;

    public Circle() {
        this.c = new Point(0, 0);
        this.r = 0;
        this.menu();
    }

    public Circle(Point c, double r) {
        this.c = c;
        this.r = r;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }


    @Override
    boolean isValid() {
        return true;
    }

    @Override
    void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(">>>>> START CREATE CIRCLE <<<<<");
        System.out.println(">>> Create point Center(x, y)");
        this.c.input();
        System.lineSeparator();
        System.out.print(">>> Enter r: ");
        this.r = scanner.nextDouble();
        System.lineSeparator();
    }

    @Override
    void output() {
        System.out.printf("\t _ Circle center(%.0f,%.0f)%n", this.c.getX(), this.c.getY());
        this.perimeterCalculate();
        this.areaCalculate();
    }

    @Override
    void perimeterCalculate() {
        double circlePerimeter = 2 * this.r * Math.PI;
        System.out.println("\t _ hu vi hinh tron: " + circlePerimeter);
    }

    @Override
    void areaCalculate() {
        double circleArea = this.r * this.r * Math.PI;
        System.out.println("\t _ Dien tich hinh tron: " + circleArea);
    }

    private void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\t | Menu Circle:                      \t|");
            System.out.println("\t | 1. Create Circle                  \t|");
            System.out.println("\t | 2. Check valid of Circle          \t|");
            System.out.println("\t | 3. Calculate perimeter of Circle  \t|");
            System.out.println("\t | 4. Calculate area of Circle       \t|");
            System.out.println("\t | 5. Show info of Circle            \t|");
            System.out.println("\t | 6. Cancel                           \t|");
            System.out.print(">>>>> Enter your choice[1-6]: ");
            choice = scanner.nextInt();

            boolean checkIsValid = false;

            switch (choice) {
                case 1:
                    this.input();
                    checkIsValid = isValid();
                    if (checkIsValid) {
                        System.out.println("Circle is valid");
                    } else {
                        System.out.println("Circle is not valid");
                    }
                    break;
                case 2:
                    checkIsValid = isValid();
                    if (checkIsValid) {
                        System.out.println("Circle is valid");
                    } else {
                        System.out.println("Circle is not valid");
                    }
                    break;
                case 3:
                    checkIsValid = isValid();
                    if (checkIsValid) {
                        this.perimeterCalculate();
                    } else {
                        System.out.println("Circle is not valid");
                    }
                    break;
                case 4:
                    checkIsValid = isValid();
                    if (checkIsValid) {
                        this.areaCalculate();
                    } else {
                        System.out.println("Circle is not valid");
                    }
                    break;
                case 5:
                    this.output();
                    break;
                case 6:
                    System.out.println(">End.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);

    }
}
