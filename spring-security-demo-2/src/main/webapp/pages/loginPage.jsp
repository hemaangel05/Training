<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
	<head>
		<title>Home</title>
		<base href="/"/>
	</head>
	<body>
		<h1>Login</h1>
		
		<form action="login" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<c:if test="${param.err eq true }">
				<p><strong> Incorrect username or password! Access Denied</strong></p>
			
			</c:if>
			
			<label>Username:</label>
			<input type="text" name="unm"/></label>
			<label>Password:</label>
			<input type="password" name="pwd"/></label>
			<button>Sign In</button>
		</form>
	</body>
</html>