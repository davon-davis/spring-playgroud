package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello from Spring!";
    }

    @GetMapping("/math/pi")
    public String getPi() {
        return "3.141592653589793";
    }

    @GetMapping("/animals")
    public String getAnimals(@RequestParam (defaultValue = "dog") String animal,
                             @RequestParam (defaultValue = "88") String age) {
        return animal + "s are the best when they are " + age;
    }

    @RequestMapping("/math/volume/{length}/{width}/{height}")
    public String getRectangleValue(@PathVariable int length,
                                    @PathVariable int width,
                                    @PathVariable int height) {
        int result = (length*width*height);

        return String.format("The volume of a %dx%dx%d rectangle is " + result, length, width, height);
    }

    @GetMapping("/cookie")
    public String accessCookieInformation(@CookieValue(name = "key") String value){
        return "This is our cookie: " + value;
    }

    @GetMapping("/flights/flight")
    public Flights getFlight(){
        Date depart = new Date(117, 03, 21, 9, 34);

        Flights.Tickets.Person passenger = new Flights.Tickets.Person("Dave", "Chappelle");

        Flights.Tickets daveTicket = new Flights.Tickets(passenger, 200);

        List<Flights.Tickets> tickets = new ArrayList<>();

        tickets.add(daveTicket);

        Flights flight = new Flights(depart, tickets);

        return flight;
    }

    @GetMapping("/flights")
    public List<Flights> getMultipleFlights() throws ParseException {
        //Date depart = new Date(117, 03, 21, 9, 34);

        String string = "2017-04-21 14:34";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        Date depart = format.parse(string);


        Flights.Tickets.Person passenger1 = new Flights.Tickets.Person("Dave", "Chappelle");
        Flights.Tickets.Person passenger2 = new Flights.Tickets.Person(null, null);

        Flights.Tickets daveTicket = new Flights.Tickets(passenger1, 200);
        Flights.Tickets bradTicket = new Flights.Tickets(passenger2, 400);

        List<Flights.Tickets> daveTickets = new ArrayList<>();
        List<Flights.Tickets> bradTickets = new ArrayList<>();

        daveTickets.add(daveTicket);
        bradTickets.add(bradTicket);

        Flights daveFlight = new Flights(depart, daveTickets);
        Flights bradFlight = new Flights(depart, bradTickets);

        List<Flights> flightList = new ArrayList<>();

        flightList.add(daveFlight);
        flightList.add(bradFlight);

        return flightList;
    }

    @PostMapping("/flights/tickets/total")
    public FlightCalculator addRides(@RequestBody Flights flight){
        FlightCalculator calc = new FlightCalculator(flight);
        calc.sum();
        return calc;
    }
}