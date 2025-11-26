package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/chefs")
public class ChefController {
    private final ChefService chefService;
    private final DishService dishService;

    public ChefController(ChefService chefService, DishService dishService){
        this.chefService=chefService;
        this.dishService=dishService;
    }

    @GetMapping
    public String getChefsPage(Model model, @RequestParam(required = false) String error) {

        if (error != null && !error.isEmpty()) {
            model.addAttribute("error", error);
        }

        model.addAttribute("chefs", chefService.listChefs());
        return "listChef";
    }

    @GetMapping("/{id}")
    public String getChefDetails(@PathVariable Long id, Model model) {

        Chef chef = chefService.findById(id);
        if (chef == null) {
            return "redirect:/chefs?error=ChefNotFound";
        }

        model.addAttribute("chef", chef);
        model.addAttribute("dishes", dishService.listDishes());

        return "chefDetails"; // your thymeleaf page
    }

    @PostMapping("/add-dish")
    public String addDishToChef(@RequestParam Long chefId,
                                @RequestParam Long dishId) {

        chefService.addDishToChef(chefId, dishId);
        return "redirect:/chefs/" + chefId;
    }
    @GetMapping("/select")
    public String selectChefRedirect(@RequestParam Long id) {
        return "redirect:/chefs/" + id;
    }

}
