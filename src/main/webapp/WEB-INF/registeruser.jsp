
<%@page import="org.springframework.validation.ObjectError"%>
<%@ page import="com.candidjava.spring.bean.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.err {
	color: red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>

	<h2>Simple spring form handling</h2>
	<form action="register" method="POST" modelAttribute="user">
		Name:<input type="text" name="name" /><br> Gender : Male<input
			type="radio" name="gender" value="male" /> Female<input type="radio"
			name="gender" value="female" /><br> Email : <input type="text"
			name="email" /><br> Languages : English<input type="checkbox"
			name="language" value="english" /> French<input type="checkbox"
			name="language" value="french" /> Tamil
		<input type="checkbox" name="language" value="tamil"  />
		<br> Country : <select name="country">
			<option value="">select country</option>
			<option value="india">INDIA</option>
			<option value="usa">USA</option>
			<option value="china">CHINA</option>
		</select> <br> <input type="submit" value="submit" />
	</form>
</body>
</html>