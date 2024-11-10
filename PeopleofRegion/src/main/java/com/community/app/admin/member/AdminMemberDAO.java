package com.community.app.admin.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminMemberDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public boolean isAdminMember(String a_m_id) {
		System.out.println("[AdminMemberDao] isAdminMember()");
		
		String sql = "select COUNT(*) from admin_user where a_m_id = ?";
		
		int result = jdbcTemplate.queryForObject(sql, Integer.class, a_m_id);
		
		if (result > 0) return true;
		else return false;
	}
	
	public int insertAdminMember(AdminMemberVO adminMemberVO) {
		System.out.println("[AdmionMemberDAO] insertAdminMember()");
		
		List<String> args = new ArrayList<String>();
	
		String sql = "insert into admin_user(";
		
		if (adminMemberVO.getA_m_id().equals("super admin")) {
			sql += "a_m_approval, ";
			args.add("1");
		}
		
		sql += "a_m_id, ";
		args.add(adminMemberVO.getA_m_id());
		
		sql += "a_m_pw, ";
		args.add(adminMemberVO.getA_m_pw());
		
		sql += "a_m_name, ";
		args.add(adminMemberVO.getA_m_name());
		
		sql += "a_m_reg_date, a_m_mod_date) ";
		
		if(adminMemberVO.getA_m_id().equals("super admin"))
			sql += "VALUES(?, ?, ?, ?, NOW(), NOW())";
		
		else
			sql += "VALUES(?, ?, ?, NOW(), NOW())";
		
		int result = -1;
		
		try {
			result = jdbcTemplate.update(sql, args.toArray());
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
}
