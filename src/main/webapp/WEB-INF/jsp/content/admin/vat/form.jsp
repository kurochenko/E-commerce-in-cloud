<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page trimDirectiveWhitespaces="true" %>

<c:choose>
    <c:when test="${empty vat.id}">
        <c:set value="btn.create" var="btn"/>
        <c:url value="/admin/vat/create" var="actionUrl"/>
    </c:when>
    <c:otherwise>
        <c:set value="btn.update" var="btn"/>
        <c:url value="/admin/vat/edit" var="actionUrl"/>
    </c:otherwise>
</c:choose>

<form:form method="post" action="${actionUrl}" modelAttribute="vat">
    <form:hidden path="id"/>

    <form:label path="vat">
        <spring:message code="vat.value"/>
    </form:label>
    <form:input path="vat"/>
    <form:errors path="vat"/>

    <input type="submit" value="<spring:message code="${btn}"/>"/>
</form:form> 