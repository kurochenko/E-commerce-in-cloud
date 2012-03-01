<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page trimDirectiveWhitespaces="true" %>

<p><spring:message code="category.delete.question" arguments="${category.name}"/></p><br/>
<c:url value="/admin/category/delete" var="formActionUrl"/>
<form:form method="post" action="${formActionUrl}" modelAttribute="category">
    <form:hidden path="id"/>
    <a href="<c:url value="/admin/category/list" />">
        <spring:message code="btn.no"/>
    </a>
    <input type="submit" value="<spring:message code="btn.yes"/>"/>
</form:form>