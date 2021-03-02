package com.example.demo;

public class FlightCalculator {
    private int result;
    private Flights flight;

    public FlightCalculator(Flights flight) {
        this.flight = flight;
    }

    public int sum(){
        for(int i = 0; i < flight.getTickets().size(); i++){
            this.result += flight.getTickets().get(i).getPrice();
        }
        return this.result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
