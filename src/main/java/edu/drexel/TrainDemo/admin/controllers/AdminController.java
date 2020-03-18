package edu.drexel.TrainDemo.admin.controllers;

import edu.drexel.TrainDemo.admin.models.PaymentModel;
import edu.drexel.TrainDemo.admin.services.AdminService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.ArrayList;
import java.io.*; 


@Controller
public class AdminController {
		private PaymentModel paymentModel;
		private PaymentModel paymentForm;
		private AdminService adminService;


    @GetMapping("/admin")
    public String getAdminPage(@AuthenticationPrincipal OAuth2User principal, Model model) {
        return "admin/admin_portal";
    }

		@PostMapping("/paymentForm")
		public String greetingSubmit(@ModelAttribute PaymentModel payment) {
    	return "result";
  }

		@ModelAttribute
		public void getUseCases(Model model) {
			ArrayList<String> useCases = new ArrayList<String>();
			useCases.add("payment");
			useCases.add("user");
			useCases.add("customer");
			useCases.add("groups");
			useCases.add("itineraries");
			useCases.add("orders");
			model.addAttribute("useCases", useCases);
		}
			
		
		@ModelAttribute
		public void getPayment(Model model) {
			System.out.print("test print0");			
			paymentModel = new PaymentModel("Paypal 2");				
			model.addAttribute("payment", paymentModel.getName());
		}

		@ModelAttribute
		public void getPaymentForm(Model model) {
			System.out.print("test print0");			
			paymentForm = new PaymentModel("Paypal");				
			model.addAttribute("paymentForm", paymentForm);
		}

		@ModelAttribute
		public void getUserModel(Model model) {
			System.out.print("test print1");			
			model.addAttribute("user", "Manage Users");
		}
		
		@ModelAttribute
		public void getCustomerModel(Model model) {
			System.out.print("test print2");			
			model.addAttribute("customer", "Manage Customer");
		}

		@ModelAttribute
		public void getGroupsModel(Model model) {
			System.out.print("test print3");			
			model.addAttribute("groups", "Manage Groups");
		}

		@ModelAttribute
		public void getItineraryModel(Model model) {
			System.out.print("test print4");			
			model.addAttribute("itineraries", "Manage Itineraries");
		}


		@ModelAttribute
		public void getOrderModel(Model model) {
			System.out.print("test print5");			
			model.addAttribute("orders", "Manage Orders");
		}


//		@ModelAttribute
//		public void getUserInfoModel(Model model) {
//			System.out.print("test print6");			
//			model.addAttribute("user", "Manage Users");
//		}


//		@ModelAttribute
//		public void getUserInfoModel(Model model) {
//			System.out.print("teddst print2");			
//			model.addAttribute("user", "Manage Users");
//		}

}


