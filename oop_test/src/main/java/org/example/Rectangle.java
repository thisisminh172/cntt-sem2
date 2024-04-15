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
public class Rectangle extends Geometry {
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Rectangle() {
        this.a = new Point(0, 0);
        this.b = new Point(0, 0);
        this.c = new Point(0, 0);
        this.d = new Point(0, 0);
        this.menu();
    }

    public Rectangle(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public Point getD() {
        return d;
    }

    public void setD(Point d) {
        this.d = d;
    }

    @Override
    void input() {
        System.out.println(">>>>> START CREATE RECTANGLE <<<<<");
        System.out.println(">>> Start create point A(x, y)");
        this.a.input();
        System.lineSeparator();
        System.out.println(">>> Start create point B(x, y)");
        this.b.input();
        System.lineSeparator();
        System.out.println(">>> Start create point C(x, y)");
        this.c.input();
        System.lineSeparator();
        System.out.println(">>> Start create point D(x, y)");
        this.d.input();
        System.lineSeparator();
    }

    @Override
    void output() {
        System.out.printf("\t _ Rectangle A(%.0f,%.0f) B(%.0f,%.0f) C(%.0f,%.0f) D(%.0f,%.0f)%n", this.a.getX(), this.a.getY(), this.b.getX(), this.b.getY(), this.c.getX(), this.c.getY(), this.d.getX(), this.d.getY());
        this.perimeterCalculate();
        this.areaCalculate();
    }

    @Override
    boolean isValid() {
        double xA = this.a.getX();
        double yA = this.a.getY();
        double xB = this.b.getX();
        double yB = this.b.getY();
        double xC = this.c.getX();
        double yC = this.c.getY();
        double xD = this.d.getX();
        double yD = this.d.getY();

        // Kiểm tra tất cả các điểm có cùng tọa độ không
        if (xA == xB && xB == xC && xC == xD && yA == yB && yB == yC && yC == yD) {
            return false;
        }

        // Kiểm tra cạnh AB và cạnh CD có cùng độ dài
        double doDaiAB = Math.sqrt((xB - xA) * (xB - xA) + (yB - yA) * (yB - yA));
        double doDaiCD = Math.sqrt((xD - xC) * (xD - xC) + (yD - yC) * (yD - yC));
        if (doDaiAB != doDaiCD) {
            return false;
        }

        // Kiểm tra cạnh BC và cạnh AD có cùng độ dài
        double doDaiBC = Math.sqrt((xC - xB) * (xC - xB) + (yC - yB) * (yC - yB));
        double doDaiAD = Math.sqrt((xD - xA) * (xD - xA) + (yD - yA) * (yD - yA));
        if (doDaiBC != doDaiAD) {
            return false;
        }

        // Kiểm tra đường chéo AC và đường chéo BD có cùng độ dài
        double doDaiAC = Math.sqrt((xC - xA) * (xC - xA) + (yC - yA) * (yC - yA));
        double doDaiBD = Math.sqrt((xD - xB) * (xD - xB) + (yD - yB) * (yD - yB));
        if (doDaiAC != doDaiBD) {
            return false;
        }

        // Kiểm tra góc vuông
        double dotProduct = (xB - xA) * (xC - xB) + (yB - yA) * (yC - yB);
        if (dotProduct != 0) {
            return false;
        }

        return true;
    }

    @Override
    void perimeterCalculate() {
        double sideAB = new LineSegment(this.a, this.b).length();
        double sideBC = new LineSegment(this.b, this.c).length();
        double rectanglePerimeter = (sideAB + sideBC) * 2;
        System.out.println("\t _ Chu vi hinh chu nhat: " + rectanglePerimeter);
    }

    @Override
    void areaCalculate() {
        double sideAB = new LineSegment(this.a, this.b).length();
        double sideBC = new LineSegment(this.b, this.c).length();
        double areaPerimeter = sideAB * sideBC;
        System.out.println("\t _ Dien tich hinh chu nhat: " + areaPerimeter);
    }

    private void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\t | Menu Rectangle:                      \t|");
            System.out.println("\t | 1. Create Rectangle                  \t|");
            System.out.println("\t | 2. Check valid of Rectangle          \t|");
            System.out.println("\t | 3. Calculate perimeter of Rectangle  \t|");
            System.out.println("\t | 4. Calculate area of Rectangle       \t|");
            System.out.println("\t | 5. Show info of Rectangle            \t|");
            System.out.println("\t | 6. Cancel                           \t|");
            System.out.print(">>>>> Enter your choice[1-6]: ");
            choice = scanner.nextInt();

            boolean checkIsValid = false;

            switch (choice) {
                case 1:
                    this.input();
                    checkIsValid = isValid();
                    if (checkIsValid) {
                        System.out.println("Rectangle is valid");
                    } else {
                        System.out.println("Rectangle is not valid");
                    }
                    break;
                case 2:
                    checkIsValid = isValid();
                    if (checkIsValid) {
                        System.out.println("Rectangle is valid");
                    } else {
                        System.out.println("Rectangle is not valid");
                    }
                    break;
                case 3:
                    checkIsValid = isValid();
                    if (checkIsValid) {
                        this.perimeterCalculate();
                    } else {
                        System.out.println("Rectangle is not valid");
                    }
                    break;
                case 4:
                    checkIsValid = isValid();
                    if (checkIsValid) {
                        this.areaCalculate();
                    } else {
                        System.out.println("Rectangle is not valid");
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
