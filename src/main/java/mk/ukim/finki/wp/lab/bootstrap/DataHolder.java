package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Chef> chefs = new ArrayList<>();
    public static List<Dish> dishes = new ArrayList<>();

    @PostConstruct
    public void init(){

        Dish d1 = new Dish("d1", "Pasta Carbonara", "Italian", 20);
        Dish d2 = new Dish("d2", "Beef Wellington", "British", 45);
        Dish d3 = new Dish("d3", "Chicken Tikka Masala", "Indian", 35);
        Dish d4 = new Dish("d4", "Sushi Set", "Japanese", 25);
        Dish d5 = new Dish("d5", "Tacos al Pastor", "Mexican", 30);

//        dishes.add(d1);
//        dishes.add(d2);
//        dishes.add(d3);
//        dishes.add(d4);
//        dishes.add(d5);
        dishes.addAll(List.of(d1,d2,d3,d4,d5));

        Chef c1 = new Chef(1L, "Gordon", "Ramsay", "Michelin-starred chef and TV host.");
        Chef c2 = new Chef(2L, "Massimo", "Bottura", "Italian cuisine innovator.");
        Chef c3 = new Chef(3L, "Asma", "Khan", "Indian home-style cooking advocate.");
        Chef c4 = new Chef(4L, "Nobu", "Matsuhisa", "Peruvian-Japanese fusion pioneer.");
        Chef c5 = new Chef(5L, "Enrique", "Olvera", "Modern Mexican cuisine leader.");

        c1.setDishes(d2);
        c2.setDishes(d1);
        c3.setDishes(d3);
        c4.setDishes(d4);
        c5.setDishes(d5);

        chefs.addAll(List.of(c1,c2,c3,c4,c5));
    }
}