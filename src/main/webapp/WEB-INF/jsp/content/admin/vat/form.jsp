<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page trimDirectiveWhitespaces="true" %>

<c:choose>
    <c:when test="${empty vatObject.id}">
        <c:set value="btn.create" var="btn"/>
        <c:url value="/admin/vat/create" var="actionUrl"/>
    </c:when>
    <c:otherwise>
        <c:set value="btn.update" var="btn"/>
        <c:url value="/admin/vat/edit" var="actionUrl"/>
    </c:otherwise>
</c:choose>

<form:form method="post" action="${actionUrl}" modelAttribute="vatObject">
    <form:hidden path="id"/>

    <form:label path="vat">
        <spring:message code="vat.value"/><em>*</em>:
        <form:errors path="vat" cssClass="error"/>
    </form:label>
    <form:input path="vat"/>

    <div class="buttons">
        <button type="submit"><spring:message code="${btn}"/></button>
    </div>
</form:form> 