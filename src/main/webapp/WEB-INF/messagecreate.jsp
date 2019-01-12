
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

	<h2>Message Create</h2>
                
	<form action="createmsg" method="POST" modelAttribute="message">
            Message <input type="text" name="data" /><br> 
            ID : <input type="number" name="id" /><br> 
            Receiver ID : <input type="number" name="receiver_id" /><br>
            Sender ID : <input type="number" name="sender_id" /> <br>
            <input type="submit" value="submit" />
	</form>
</body>
</html>