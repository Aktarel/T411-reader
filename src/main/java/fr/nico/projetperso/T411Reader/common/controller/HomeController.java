package fr.nico.projetperso.T411Reader.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author akta
 *
 */
@Controller
public class HomeController {
	
    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
}
	