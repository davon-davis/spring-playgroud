package com.example.demo;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;
import java.util.List;

public class Flights {
    @JsonProperty("Departs")
    private Date departs;
    @JsonProperty("Tickets")
    private List<Tickets> tickets;

    //@JsonCreator
    public Flights(Date departs, List<Tickets> tickets) {
        this.departs = departs;
        this.tickets = tickets;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    public Date getDeparts() {
        return departs;
    }

    public void setDeparts(Date departs) {
        this.departs = departs;
    }

    public List<Tickets> getTickets() {
        return tickets;
    }

    public void setTickets(List<Tickets> tickets) {
        this.tickets = tickets;
    }

    static class Tickets{
        @JsonProperty("Passenger")
        private Person passenger;
        @JsonProperty("Price")
        private int price;

        //@JsonCreator
        public Tickets(Person passenger, int price) {
            this.passenger = passenger;
            this.price = price;
        }

        public Person getPassenger() {
            return passenger;
        }

        public void setPassenger(Person passenger) {
            this.passenger = passenger;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        static class Person{
            @JsonProperty("FirstName")
            private String firstName;
            @JsonProperty("LastName")
            private String lastName;

            //@JsonCreator
            public Person( String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }
        }
    }


}
