<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="viewPage">
<p>
	<h3 class="alt">${entity.title}</h3>
	
	<fieldset>
		<c:forEach var="menu" items="${menus}">
    	<h4>${menu.name}<h4>
    	<ul>
    		<c:forEach var="menuItem" items="${menu.menuItems}">
    		  <li> <a href="${menuItem.hyperLink}"> ${menuItem.text}</a></li>
    		</c:forEach>
    	</ul>
		</c:forEach>
	</fieldset>

</p>
</div>