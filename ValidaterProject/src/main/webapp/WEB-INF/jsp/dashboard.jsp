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
<title>Insert title here</title>
 <link rel="stylesheet" href="css/styles.css" type="text/css" /> 
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script src="<c:url value="/js_dev/jsdev.js" />"></script> 



</head>
<body>
<div id="container">
		<header>
			<h1>
					<a href="/">Validator<span> Project</span></a>
			</h1>
			
		</header>
		<nav>
			
			
			
			
			<c:choose>
			<c:when test="${user!=''}">
			<ul>
			    <li class=""><a	href="#">tab1</a></li>
				<li class=""><a href="#">tab2</a></li>
				<li class=""><a href="#">tab3</a></li>
				<li class=""><a href="#">tab4</a></li>
				<li style="float: right;"><a href="logout">Logout</a></li>
				<li	style="float: right; color: #eee; padding: 28px 20px 25px; font-size: 13px; text-transform: uppercase; font-family: 'Pontano Sans', Arial, sans-serif; text-decoration: underline;">Welcome,
					<span> ${user.firstname} ${user.lastname} </span>
				</li>
			</ul>
			</c:when>
			
			<c:otherwise>
			<ul>
				
				<li style="float: right;"><a href="login">Login</a></li>
			</ul>
			</c:otherwise>
			</c:choose>
		
		
		
	
		
		
		
		
		</nav>
		<div id="body">
			<section id="content">
				<article>
					<table>
					<tr>
					<td>	<h3>FUTURE ENHANCEMENT</h3>				</td>
					<td >
					
					<%-- <c:choose>
			<c:when test="${userdetailsdata.id!=null}">
					<a href="AddProduct?id=${userdetailsdata.id}&cat=${Maincat}"><button type="button" value="Add Product" class="formbutton" style="background-color: #DE2D3A;"><font color="White">Add Product</font></button></a>
				</c:when>
				<c:otherwise></c:otherwise>	
					</c:choose> --%>
					
					
					
					</td> 
					</tr>
					</table>
					
					
					

					<img src="images/UC.jpg" alt="Under construction" width=400 height=300>
					
				</article>
			</section>
			
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>