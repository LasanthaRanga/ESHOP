<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<table>
		<tbody>


			<c:forEach items="${users}" var="User">
				<tr>
					<td>${User.userName}</td>
					<td>${User.userEmail}</td>
					<td>${User.gender}</td>
					<td>${User.getUsertype().getUserTypeName()}</td>
					<td>
						<form method="post" action="login">
							<input name="userEmail" value="${User.userEmail}" type="text"/>
							<input name="userPassword" value="${User.userPassword}" type="text"/>
							<input type="submit">
						</form>
					</td>
				</tr>
			</c:forEach>


		</tbody>
	</table>





</body>
</html>