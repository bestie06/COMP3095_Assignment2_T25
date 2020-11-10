/*******************************************************************************************************************
 * Project: Comp-3095 Assignment 2
 * Assignment: 2
 * Author(s): Zac Shaw, Yazan Siyam, Joushua Burnett Rooney, Fatih Kucukgokmen
 * Student Number: 101074878, 101210557 , 101212739, 101168654
 * Date: 11/08/2020
 * Description: controller for redirect
 * ****************************************************************************************************************/

package com.ValidaterProject.Controller;

import com.ValidaterProject.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RedirectController {

	
	@GetMapping(value = "/")
	public ModelAndView index(Model model) {
		return new ModelAndView("login");
	}

	

	@GetMapping(value = "dashboard")
	public ModelAndView dashboard(Model model) {
		return new ModelAndView("dashboard");
	}

	@GetMapping(value = "register")
	public ModelAndView Thefoundallocation(Model model) {
		return new ModelAndView("register");
	}
	
}
