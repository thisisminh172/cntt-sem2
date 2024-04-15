/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author minh-user
 */
public class LineSegment extends Geometry {
    private Point a;
    private Point b;

    public LineSegment(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public LineSegment() {
        this.a = new Point(0, 0);
        this.b = new Point(0, 0);
        this.menu();
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }
    public double length() {
        double value = Math.sqrt(Math.pow(this.a.getX() - this.b.getX(), 2) + Math.pow(this.a.getY()- this.b.getY(), 2));
        return value;
    }




    @Override
    public void input() {
        System.out.println(">>>>> START CREATE LINE SEGMENT <<<<<");
        System.out.println(">>> Start create point A(x, y)");
        this.a.input();
        System.lineSeparator();
        System.out.println(">>> Start create point B(x, y)");
        this.b.input();
        System.lineSeparator();
    }

    @Override
    public void output() {
        System.out.printf("\t _ Line segment A(%.0f,%.0f) B(%.0f,%.0f)%n", this.a.getX(), this.a.getY(), this.b.getX(), this.b.getY());
        System.out.printf("\t _ Line segment's length:  %.0f%n", this.length());
    }

    @Override
    boolean isValid() {
        return false;
    }

    @Override
    void perimeterCalculate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    void areaCalculate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\t | Menu LineSegment:                      \t\t|");
            System.out.println("\t | 1. Create LineSegment                  \t\t|");
            System.out.println("\t | 2. Calculate the length of LineSegment \t\t|");
            System.out.println("\t | 3. Show info of LineSegment            \t\t|");
            System.out.println("\t | 4. Cancel                              \t\t|");
            System.out.print(">>>>> Enter your choice[1-4]: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    this.input();
                    break;
                case 2:
                    System.out.println("Line segment's length: " + this.length());
                    break;
                case 3:
                    this.output();
                    break;
                case 4:
                    System.out.println(">End.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);

    }


}
