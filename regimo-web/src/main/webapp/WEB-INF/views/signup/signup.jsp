<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:if test="${not empty message}">
<div class="${message.type.cssClass}">${message.text}</div>
</c:if>

<c:url value="/signup" var="signupUrl" />
<form:form id="signup" action="${signupUrl}" method="post" modelAttribute="userNewForm">
	<div class="formInfo">
  		<h2><spring:message code="main.registration.signup"/></h2>
  		<s:bind path="*">
  		<c:choose>
  		<c:when test="${status.error}">
  			<div class="error"><spring:message code="error.new"/></div>
  		</c:when>
  		</c:choose>			
  		</s:bind>
	</div>
	<%@ include file="signupForm.jspf" %>
	<p><button type="submit"><spring:message code="main.registration.signup"/></button></p>
</form:form>