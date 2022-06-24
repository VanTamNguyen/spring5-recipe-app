package guru.springframework.spring5recipeapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping(value = "/rest/endpoint", method = RequestMethod.GET)
    public Map<String, String> restEndpoint() {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "world");
        return  map;
    }
}
