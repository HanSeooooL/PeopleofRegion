package com.community.app.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {
	
	@Autowired
	AdminMemberService adminMemberService;
	
	@RequestMapping(value = "/adminsignup", method = RequestMethod.GET)
	public String adminSignUp() {
		System.out.println("[AdminMemberController] adminSignUp()");
		String nextPage = "admin_sign_up_form";
		
		return nextPage;
	}
	
	@PostMapping("/adminsignupconfirm")
	public String adminSignUpConfirm(AdminMemberVO adminMemberVO) {
		System.out.println("[AdminMembercontroller] adminSignUpConfirm()");
		String nextPage = "admin_sign_up_ok";
		
		int result = adminMemberService.createAccountConfirm(adminMemberVO);
		
		if (result <= 0) nextPage = "admin_sign_up_ng";
		
		return nextPage;
	}
	
	
}
