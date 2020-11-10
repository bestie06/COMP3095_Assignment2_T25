<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="../CSS/styles.css" type="text/css" />
<script src="../JS/jquery.js" /></script>
<script src="../JS/osms.js" /></script>
</head>
<body>
	<div id="container">
		<header>
		<h1>
			<a href="/">Validator<span> Project</span></a>
		</h1>
		</header>
		<nav>
		<ul>
			<li class="selected"><a href="#">REGISTER</a></li>
			<li style="float: right"><a href="/">Login</a></li>

		</ul>
		</nav>
		<div id="body">
			<section id="content"> <article>
			<h3>Registation Page</h3>
			<div id="error" style="color: red;"></div>
			<fieldset>
				<%-- <form method="post" action="/saveUser" onsubmit="userRegister()"> --%>
				<form method="post" action="/saveUser" onsubmit=" return userRegister();">
<div id="divv" style="margin-right: 25%;">
					<c:choose>
						<c:when test="${msg == ' '}">
						</c:when>
						<c:otherwise>
							<p align='center'>
								<font color="red"> ${msg} </font>
							</p>
						</c:otherwise>
					</c:choose>
</div>
					<input type=hidden id="sid" name="sid">

					<p>
						<label for="sfname"> First name:</label> <input name="firstname"
							id="firstname" type="text" required="required"
							oninvalid="this.setCustomValidity('Please Enter first name')"
							onkeypress="javascript: return onlyChars(event);"
							oninput="setCustomValidity('')" />
					</p>
					
					<p>
						<label for="slname">Last name:</label> <input name="lastname"
							id="lastname" type="text" required="required"
							oninvalid="this.setCustomValidity('Please Enter Last name')"
							onkeypress="javascript: return onlyChars(event);"
							oninput="setCustomValidity('')" />
					</p>
					<p>
						<label for="slname">Address:</label> <input name="address"
							id="address" type="text" required="required"
							oninvalid="this.setCustomValidity('Please Enter Address')"
							oninput="setCustomValidity('')" />
					</p>
					<p>
						<label for="semail">Email:</label> <input name="email" id="email"
							type="text" required="required"
							oninvalid="this.setCustomValidity('Please Enter email id')"
							oninput="setCustomValidity('')" />
					</p>

					<p>
						<label for="contact">Password:</label> <input name="password"
							id="password" type="password" required="required"
							oninvalid="this.setCustomValidity('Please Enter Password')"
							oninput="setCustomValidity('')" />
					</p>

					<p>
						<label for="contact"> Do you accept the terms and services?</label> <input name="agree"
							id="agree" type="checkbox" required="required"
							oninvalid="this.setCustomValidity('do you accept terms and services?')"
							oninput="setCustomValidity('')" />
					</p>

					<p>
						<input name="register" type="submit" style="margin-left: 100px;"
							class="formbutton" value=Register /> <a href="/"><input
							name="cancel" class="formbutton" value="Cancel" type="button" /></a>
					</p>
				</form>
			</fieldset>
			</article> </section>


			<div class="clear"></div>
		</div>
	</div>
</body>
</html>