package com.piaget.VZoo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {

	@GetMapping("/zooPage")
	public String novo (Model model){
		model.addAttribute("zooPage", new ZooApp());
		return "zooPage";
	}

	@PostMapping("/zooPage")
	public String gotoMainPage(@ModelAttribute ZooApp zooPage){
		return "zooPage";
	}

	@PostMapping("/mainpage")
    public String goToAnimalPage(@ModelAttribute AnimalPage zooPage) {
        return "animalPage";
    }


}
