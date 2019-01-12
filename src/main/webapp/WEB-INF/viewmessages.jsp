<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Message</title>
</head>
<body>
<h2>Message</h2>

<strong>Message id</strong>: ${message.id} <br>
<strong>Sender id </strong> : ${message.sender_id}<br>
<strong>Receiver id </strong> : ${message.receiver_id}<br>
<strong>Data </strong> : ${message.data}<br>

	
</body>
</html>