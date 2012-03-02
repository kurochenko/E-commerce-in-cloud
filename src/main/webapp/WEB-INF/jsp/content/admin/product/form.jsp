<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page trimDirectiveWhitespaces="true" %>

<c:choose>
    <c:when test="${empty product.id}">
        <c:set value="btn.create" var="btn"/>
        <c:url value="/admin/product/create" var="actionUrl"/>
    </c:when>
    <c:otherwise>
        <c:set value="btn.update" var="btn"/>
        <c:url value="/admin/product/edit" var="actionUrl"/>
    </c:otherwise>
</c:choose>

<form:form method="post" action="${actionUrl}" modelAttribute="product">

    <form:hidden path="id"/>

    <form:label path="name">
        <spring:message code="product.name"/>
    </form:label>
    <form:input path="name"/>
    <form:errors path="name"/><br/>

    <form:label path="description">
        <spring:message code="product.description"/>
    </form:label>
    <form:textarea path="description"/>
    <form:errors path="description"/><br/>

    <form:label path="price">
        <spring:message code="product.price"/>
    </form:label>
    <form:input path="price"/>
    <form:errors path="price"/><br/>

    <form:label path="amount">
        <spring:message code="product.amount"/>
    </form:label>
    <form:input path="amount"/>
    <form:errors path="amount"/><br/>

    <form:label path="vat">
        <spring:message code="product.vat"/>
    </form:label>
    <form:select path="vat">
        <form:options items="${vats}" itemLabel="vat" itemValue="id"/>
    </form:select>
    <form:errors path="vat"/><br/>

    <form:label path="category">
        <spring:message code="product.category"/>
    </form:label>
    <form:select path="category">
        <form:options items="${categories}" itemLabel="name" itemValue="id"/>
    </form:select>
    <form:errors path="category"/><br/>

    <input type="submit" value="<spring:message code="${btn}"/>"/>
</form:form> 