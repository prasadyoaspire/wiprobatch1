package com.abc.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abc.springweb.exceptions.LoginFailureException;
import com.abc.springweb.model.Login;

@Controller
public class LoginController {
		
	@RequestMapping(value = "/loginform", method = RequestMethod.GET)
	public ModelAndView getLoginForm() {
		return new ModelAndView("login-form","loginform",new Login() );
	}
	
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String loginProcess(@ModelAttribute("loginform") Login login, Model model) {
		
		//if password is '1234' return login-success.jsp else return login-failure.jsp		
		if(!login.getPassword().equals("1234")) {
			throw new LoginFailureException("Invalid credentials");
		}
		String msg = "Weclome "+login.getUsername();
		model.addAttribute("message", msg);
		return "login-success";	
	}
	
	@ExceptionHandler(LoginFailureException.class)
	public ModelAndView handleLoginFailureException(Exception e) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error-page");
		modelAndView.addObject("message", e.getMessage());
		return modelAndView;
	}	
	
}
