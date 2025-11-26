package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.ChefRepository;
import mk.ukim.finki.wp.lab.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChefServiceImpl implements ChefService{

    private final ChefRepository chefRepository;
    private final DishRepository dishRepository;

    public ChefServiceImpl(ChefRepository chefRepository, DishRepository dishRepository) {
        this.chefRepository = chefRepository;
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Chef> listChefs() {
        return chefRepository.findAll();
    }

    @Override
    public Chef findById(Long id) {
        return chefRepository.findById(id).orElse(null);
    }

//    @Override
//    public Chef addDishToChef(Long chefId, Long dishId) {
//        Chef chef = findById(chefId);
//        Dish dish = dishRepository.findByDishId(dishId);
//        if(dish == null){
//            System.out.println("Dish not found:" + dishId);
//            return null;
//        }
//        chef.setDishes(dish);
//        return chefRepository.save(chef);
//    }

    @Override
    public Chef addDishToChef(Long chefId, Long dishId) {
        Chef chef = findById(chefId);
        Dish dish = dishRepository.findById(dishId).orElse(null);

        if (chef == null || dish == null) {
            return null;
        }

        chef.setDishes(dish);
        return chefRepository.save(chef);
    }

}