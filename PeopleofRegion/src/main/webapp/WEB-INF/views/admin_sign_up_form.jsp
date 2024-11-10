<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="${path}/resources/css/admin/admin_sign_up_form.css" rel="stylesheet"/> 
</head>
<body>
	<section>
		<div id="section_wrap">
			<div id="form_title">
				<h3>회원 가입</h3>
			</div>
			
			<div id="admin_signup_form">
			
				<form action="<c:url value='admin/memeber/createAdminMemberConfirm'/>" name="create_admin_member_form" method="post" >
					
					<input type="text" name="a_m_id" placeholder="아이디를 입력해주세요" class="input"> <br/>
					<input type="password" name="a_m_pw" placeholder="비밀번호를 입력해주세요" class="input"> <br/>
					<input type="password" name="a_m_pw" placeholder="비밀번호 확인" class="input"> <br/>
					<input type="text" name="a_m_id" placeholder="아이디를 입력해주세요" class="input"> <br/>
					<input type="text" name="a_m_id" placeholder="아이디를 입력해주세요" class="input"> <br/>
					<input type="text" name="a_m_id" placeholder="아이디를 입력해주세요" class="input"> <br/>
					
				</form>
			</div>
			
		</div>
	</section>
</body>
</html>