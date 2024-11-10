package com.community.app.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminMemberService {
	
	final static public int ADMIN_ACCOUNT_ALREADY_EXIST = 0;
	final static public int ADMIN_ACCOUNT_CREATE_SUCCESS = 1;
	final static public int ADMIN_ACCOUNT_CREATE_FAIL = -1;
	
	@Autowired
	AdminMemberDAO adminMemberDAO;
	
	public int createAccountConfirm(AdminMemberVO adminMemberVO) {
		System.out.println("[AdminMemberService] createAccountconfirm()");
		
		boolean isMember = adminMemberDAO.isAdminMember(adminMemberVO.getA_m_id());
		
		if(!isMember) {
			int result = adminMemberDAO.insertAdminMember(adminMemberVO);
			
			if (result > 0) return ADMIN_ACCOUNT_CREATE_SUCCESS;
			else return ADMIN_ACCOUNT_CREATE_FAIL;
		} else return ADMIN_ACCOUNT_ALREADY_EXIST;
	}
}
