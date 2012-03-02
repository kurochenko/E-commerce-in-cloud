<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page trimDirectiveWhitespaces="true" %>
<ul>
    <c:forEach items="${menuCategories}" var="category">
        <li><a href="<c:url value="/category/${category.id}/list" />">${category.name}</a></li>
    </c:forEach>
</ul>