package com.ge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ge.dto.Admin;
import com.ge.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		return "home";
	}

	@GetMapping("/showAllAdmins")
	public String showAllAdmins(Model model) {
		model.addAttribute("listAdmins", adminService.getAllAdmins());
		return "showAllAdmins";
	}

	@GetMapping("/showNewAdminForm")
	public String showNewAdminForm(Model model) {
		// create model attribute to bind form data
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "new_admin";
	}

	@PostMapping("/saveAdmin")
	public String saveAdmin(@ModelAttribute("admin") Admin admin) {
		// save admin to database
		adminService.saveAdmin(admin);
		return "redirect:/";
	}

	@GetMapping("/showNewAdminLoginForm")
	public String showNewAdminLoginForm(Model model) {
		// create model attribute to bind form data
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "login_admin";
	}

	@PostMapping("/loginAdmin")
	public String loginAdmin(@ModelAttribute("admin") Admin admin) {
		// save admin to database

		if (adminService.adminLogin(admin)) {
			return "redirect:/";
		}
		else {
			return "redirect:/login_admin";
		}
	}

}
