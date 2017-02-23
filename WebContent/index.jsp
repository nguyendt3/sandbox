<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TICS II Demonstration Web Application</title>

</head>
<body>
	<h1 id="title">TICS II Demonstration Web Application</h1>
	<h2 id="subtitle">Call microservices:</h2>
	<div id="callMicroserviceA">
		<a id="linkCallMicroservicesA" href="getWidgetsA">Get 100 widget
			A's</a>
	</div>
	<div id="callMicroserviceAFindPrimes">
		<a id="linkCallMicroservicesAFindPrimes" href="getWidgetsAFindPrimes">Tell one of the Get Widget A's microservices to find the some primes</a>
	</div>

	<br/><br/>	
	
	<div id="callMicroserviceB">
		<a id="linkCallMicroservicesB" href="getWidgetsB">Get 100 widget
			B's</a>
	</div>
	<div id="callMicroserviceBFindPrimes">
		<a id="linkCallMicroservicesBFindPrimes" href="getWidgetsBFindPrimes">Tell one of the Get Widget B's microservices to find the some primes</a>
	</div>

	<h2 id="results">Results of call microservices:</h2>
	
	<%
		if(request.getAttribute("findPrimesA") != null) {
	%>
		<div id="findPrimeA">A pod member for getWidgetA is finding primes.</div>
	<%
		}
	%>

	<%
		if(request.getAttribute("findPrimesB") != null) {
	%>
		<div id="findPrimeB">B pod member for getWidgetA is finding primes.</div>
	<%
		}
	%>
	
	<br/>

	<table border="1" cellpadding="3" cellspacing="0">
		<tr>
			<td colspan=3">Widgets</td>
		</tr>
		<tr>
			<td>ID</td>
			<td>Type</td>
			<td>Name</td>
		</tr>

		<c:forEach items="${widgets}" var="widget">
			<tr>
				<td><c:out value="${widget.id}" /></td>
				<td><c:out value="${widget.type}" /></td>
				<td><c:out value="${widget.name}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>