package fr.nico.projetperso.T411Reader.common.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author akta
 *
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
    	List<String> services = new ArrayList<String>();
    	services.add("First");
    	services.add("Second");
    	services.add("Third");
    	model.addAttribute("services", services);
        return "index";
    }
    
}
	