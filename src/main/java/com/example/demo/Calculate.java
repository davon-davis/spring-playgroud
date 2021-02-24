package com.example.demo;

import java.util.List;

public class Calculate {
    String x;
    String y;
    String operation = "add";
    List<Integer> n;
    String type;
    int radius;
    int width;
    int height;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public List<Integer> getN() {
        return n;
    }

    public void setN(List<Integer> n) {
        this.n = n;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String doAdd(){
        int rX = Integer.parseInt(this.x);
        int rY = Integer.parseInt(this.y);

        return String.format("%s + %s = %s", rX, rY, (rX+rY));
    }

    public String doSub(){
        int rX = Integer.parseInt(this.x);
        int rY = Integer.parseInt(this.y);

        return String.format("%s - %s = %s", rX, rY, (rX-rY));
    }
    public String doMultiply(){
        int rX = Integer.parseInt(this.x);
        int rY = Integer.parseInt(this.y);

        return String.format("%s * %s = %s", rX, rY, (rX*rY));
    }
    public String doDivide(){
        int rX = Integer.parseInt(this.x);
        int rY = Integer.parseInt(this.y);

        return String.format("%s / %s = %s", rX, rY, (rX/rY));
    }

    public String sumList(){
        int sum = 0;
        String result = "";
        for(int i = 0; i < this.n.size()-1; i++){
            sum += this.n.get(i);
            result += this.n.get(i) + " + ";
        }
        sum += this.n.get(this.n.size()-1);
        result += this.n.get(this.n.size()-1);

        return result + " = " + sum;
    }

    public String areaValid(){
        String result = "Invalid";
        if(this.type.equals("circle") && this.radius > 0){
            result = String.format("Area of a circle with a radius of %d is " +
                    (Math.PI*(this.radius*this.radius)), this.radius);
        }else if(this.type.equals("rectangle") && this.width > 0 && this.height > 0){
            result = String.format("Area of a %dx%d rectangle is " +
                    (this.width*this.height), this.width, this.height);
        }

        return result;
    }
}
