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
<title>login</title>
<link rel="stylesheet" href="../CSS/styles.css" type="text/css" />
<script src="../JS/osms.js" /></script>
</head>
<body onload="createCaptcha()">
	<div id="container">
		<header>
		<h1>
			<a href="/">Validator<span> Project</span></a>
		</h1>
		</header>
		<nav>
		<ul>
			<li class="start "><a href="register">Register</a></li>
			<li class="selected" style="float: right"><a href="#">Login</a></li>
		</ul>
		</nav>
		<div id="body">
			<section id="content"> <article>
			<h3>Login</h3>
			<div id="error" style="color: red;"></div>
			<div id="success" style="color: green;"></div>
			<fieldset>
				<form action="/loginSrv" method="post" onsubmit="return validateCaptcha();>
<!--  onsubmit="return validateCaptcha();" -->
                   <c:choose>
						<c:when test="${msgs == ' '}">
						</c:when>
						<c:otherwise>
							<p align='center'>
								<font color="red"> ${msgs} </font>
							</p>
						</c:otherwise>
					</c:choose>


					<p>
						<label for="username">Username:</label> <input name="email"
							id="email" value="" type="text" required="required"
							oninvalid="this.setCustomValidity('Please Enter Username')"
							oninput="setCustomValidity('')" />
					</p>
					<p>
						<label for="password">Password:</label> <input name="password"
							id="password" value="" type="password" required="required"
							oninvalid="this.setCustomValiditys('Please Enter Password')"
							oninput="setCustomValiditys('')" />
					</p>
					
					 <div id="captcha">
    </div>
   <p> <input type="text" placeholder="Captcha" id="cpatchaTextBox" required=""/></p>
					
					<p>
						<input name="login" style="margin-left: 150px;" class="formbutton"
							value="Login" type="submit" /> 
							<a href="register"><input name="button"
							class="formbutton" value="Register" type="button" /></a>
					</p>
					<p>
						 <a href="#"> Forget your Password</a>
					</p>
				</form>
			</fieldset>
			</article> </section>
			<div class="clear"></div>
		</div>
		<footer>

		</footer>
	</div>
</body>
</html>