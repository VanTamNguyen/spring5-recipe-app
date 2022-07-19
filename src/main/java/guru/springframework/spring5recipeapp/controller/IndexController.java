package guru.springframework.spring5recipeapp.controller;

import guru.springframework.spring5recipeapp.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String indexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }

    @GetMapping("/model_map")
    public String modalMap(ModelMap modelMap) {
        modelMap.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }

    @GetMapping("/model_and_view")
    public ModelAndView modelAndView() {
        Map<String, Object> model = new HashMap<>();
        model.put("recipes", recipeService.getRecipes());
        return new ModelAndView("index", model);
    }
}
