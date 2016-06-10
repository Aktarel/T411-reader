package fr.nico.projetperso.T411Reader.common.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author akta
 *
 */
@Controller
public class HomeController {
	
	@Resource(name="services")
	List services;
	
	@RequestMapping(value="/")
    public String index(Model model) {
    	model.addAttribute("rest", services);
        return "index";
    }


}
	