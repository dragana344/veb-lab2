package mk.ukim.finki.wp.lab.model;

public class Dish {
    private String dishId;
    private String name;
    private String cuisine;
    private int preparationTime;
    private Long id;
    private static Long counter = 1L;
    private int likes;

    public Dish(String dishId, String name, String cuisine, int preparationTime) {
       this.id=counter++;
       this.preparationTime = preparationTime;
       this.cuisine = cuisine;
       this.name = name;
       this.dishId=dishId;
       this.likes=0;
    }

    public String getDishId() {
        return dishId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public int getLikes() {
        return likes;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }
}
