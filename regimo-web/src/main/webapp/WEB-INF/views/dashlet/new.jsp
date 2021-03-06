<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<s:url var="actionUrl" value="/dashlet/new"/>
<form:form action="${actionUrl}" modelAttribute="entity" method="post">
	<div class="formInfo">
  		<h2><spring:message code="dashlet.create.title"/></h2>
  		<s:bind path="*"><c:if test="${status.error}">
  		<div class="error"><spring:message code="dashlet.new.error"/>.</div>
  		</c:if></s:bind>
	</div>
	<jsp:include page="entry.jsp"/>
	<p><button type="submit"><spring:message code="button.create"/></button></p>
</form:form>