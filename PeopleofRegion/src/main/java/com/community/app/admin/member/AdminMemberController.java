package com.community.app.admin.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {
	@RequestMapping(value = "/adminsignup")
	public String adminSignUp() {
		System.out.println("[AdminMemberController] adminSignUp()");
		return "admin_sign_up_form";
	}
	
	
}
