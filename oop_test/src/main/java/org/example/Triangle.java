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
public class Triangle extends Geometry{
    private Point a;
    private Point b;
    private Point c;

    public Triangle() {
        this.a = new Point(0, 0);
        this.b = new Point(0, 0);
        this.c = new Point(0, 0);
        this.menu();
    }

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    @Override
    void input() {
        System.out.println(">>>>> START CREATE TRIANGLE <<<<<");
        System.out.println(">>> Start create point A(x, y)");
        this.a.input();
        System.lineSeparator();
        System.out.println(">>> Start create point B(x, y)");
        this.b.input();
        System.lineSeparator();
        System.out.println(">>> Start create point C(x, y)");
        this.c.input();
        System.lineSeparator();
    }

    @Override
    void output() {
        System.out.printf("\t _ Triangle A(%.0f,%.0f) B(%.0f,%.0f) C(%.0f,%.0f)%n", this.a.getX(), this.a.getY(), this.b.getX(), this.b.getY(), this.c.getX(), this.c.getY());
        this.perimeterCalculate();
        this.areaCalculate();
    }

    @Override
    boolean isValid() {
        double sideAB = new LineSegment(this.a, this.b).length();
        double sideBC = new LineSegment(this.b, this.c).length();
        double sideCA = new LineSegment(this.c, this.a).length();

        return (sideAB + sideBC > sideCA) && (sideBC + sideCA > sideAB) && (sideCA + sideAB > sideBC);
    }

    @Override
    void perimeterCalculate() {
        double sideAB = new LineSegment(this.a, this.b).length();
        double sideBC = new LineSegment(this.b, this.c).length();
        double sideCA = new LineSegment(this.c, this.a).length();
        double chuViTamGiac = sideAB + sideBC + sideCA;
        System.out.println("\t _ Chu vi tam giac: " + chuViTamGiac);
    }

    @Override
    void areaCalculate() {
        double heightOfTriangle = tinhKhoangCachDiemDenDoanThang(this.a.getX(), this.a.getY(), this.b.getX(), this.b.getY(), this.c.getX(), this.c.getY());
        double sideBC = new LineSegment(this.b, this.c).length();
        double dienTichTamGiac = (heightOfTriangle * sideBC) / 2;
        System.out.println("\t _ Dien tich tam giac: " + dienTichTamGiac);
    }

    private double tinhKhoangCachDiemDenDoanThang(double xA, double yA, double xB, double yB, double xC, double yC) {
        // Tính hệ số của đường thẳng BC: y = mx + c
        double m = (yC - yB) / (xC - xB);
        double c = yB - m * xB;

        // Tìm tọa độ điểm chiếu D của điểm A lên đoạn thẳng BC
        double xD = (xA + m * yA - m * c) / (1 + m * m);
        double yD = m * xD + c;

        // Tính khoảng cách từ điểm A đến điểm D
        double khoangCach = Math.sqrt((xA - xD) * (xA - xD) + (yA - yD) * (yA - yD));

        return khoangCach;
    }

    private void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\t | Menu Triangle:                      \t|");
            System.out.println("\t | 1. Create Triangle                  \t|");
            System.out.println("\t | 2. Check valid of Triangle          \t|");
            System.out.println("\t | 3. Calculate perimeter of Triangle  \t|");
            System.out.println("\t | 4. Calculate area of Triangle       \t|");
            System.out.println("\t | 5. Show info of Triangle            \t|");
            System.out.println("\t | 6. Cancel                           \t|");
            System.out.print(">>>>> Enter your choice[1-6]: ");
            choice = scanner.nextInt();

            boolean checkIsValid = false;

            switch (choice) {
                case 1:
                    this.input();
                    checkIsValid = isValid();
                    if (checkIsValid) {
                        System.out.println("Triangle is valid");
                    } else {
                        System.out.println("Triangle is not valid");
                    }
                    break;
                case 2:
                    checkIsValid = isValid();
                    if (checkIsValid) {
                        System.out.println("Triangle is valid");
                    } else {
                        System.out.println("Triangle is not valid");
                    }
                    break;
                case 3:
                    checkIsValid = isValid();
                    if (checkIsValid) {
                        this.perimeterCalculate();
                    } else {
                        System.out.println("Triangle is not valid");
                    }
                    break;
                case 4:
                    checkIsValid = isValid();
                    if (checkIsValid) {
                        this.areaCalculate();
                    } else {
                        System.out.println("Triangle is not valid");
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
