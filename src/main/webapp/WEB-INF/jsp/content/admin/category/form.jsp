<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page trimDirectiveWhitespaces="true" %>

<c:choose>
    <c:when test="${empty category.id}">
        <c:set value="btn.create" var="btn"/>
        <c:url value="/admin/category/create" var="actionUrl"/>
    </c:when>
    <c:otherwise>
        <c:set value="btn.update" var="btn"/>
        <c:url value="/admin/category/edit" var="actionUrl"/>
    </c:otherwise>
</c:choose>

<form:form method="post" action="${actionUrl}" modelAttribute="category">
    <form:hidden path="id"/>

    <form:label path="name">
        <spring:message code="category.name"/><em>*</em>:
        <form:errors path="name" cssClass="error"/>
    </form:label>
    <form:input path="name"/>

    <div class="buttons">
        <button type="submit" class="full"><spring:message code="${btn}"/></button>
    </div>
</form:form> 