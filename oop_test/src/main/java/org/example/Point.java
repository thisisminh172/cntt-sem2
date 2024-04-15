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
public class Point extends Geometry{
    private double x;
    private double y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(">> Please enter value x-axis: ");
        this.x = scanner.nextDouble();
        System.lineSeparator();
        System.out.print(">> Please enter value y-axis: ");
        this.y = scanner.nextDouble();
        System.lineSeparator();
        System.out.printf("Point(%.0f, %.0f) created!%n", this.x, this.y);

    }

    @Override
    void output() {
        System.out.printf("\t _ Point(%.0f, %.0f)%n", this.x, this.y);
    }

    @Override
    boolean isValid() {
        return false;
    }

    @Override
    void perimeterCalculate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    void areaCalculate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
