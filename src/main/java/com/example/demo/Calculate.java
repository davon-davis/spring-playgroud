package com.example.demo;

import java.util.List;

public class Calculate {
    String x;
    String y;
    String operation = "add";
    List<Integer> n;

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
}
