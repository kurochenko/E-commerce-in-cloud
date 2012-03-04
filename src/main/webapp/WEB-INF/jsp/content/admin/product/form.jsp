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
    <form:hidden path="created"/>

    <form:label path="category">
        <spring:message code="product.category"/><em>*</em>:
        <form:errors path="category" cssClass="error"/>
    </form:label>
    <form:select path="category">
        <form:options items="${categories}" itemLabel="name" itemValue="id"/>
    </form:select><br/>

    <form:label path="name">
        <spring:message code="product.name"/><em>*</em>:
        <form:errors path="name" cssClass="error"/>
    </form:label>
    <form:input path="name"/><br/>

    <form:label path="amount">
        <spring:message code="product.amount"/><em>*</em>:
        <form:errors path="amount" cssClass="error"/>
    </form:label>
    <form:input path="amount"/><br/>

    <form:label path="price">
        <spring:message code="product.price"/><em>*</em>:
        <form:errors path="price" cssClass="error"/>
    </form:label>
    <form:input path="price"/><br/>

    <form:label path="vat">
        <spring:message code="product.vat"/><em>*</em>:
        <form:errors path="vat" cssClass="error"/>
    </form:label>
    <form:select path="vat">
        <form:options items="${vats}" itemLabel="vat" itemValue="id"/>
    </form:select><br/>

    <form:label path="description">
        <spring:message code="product.description"/><em>*</em>:
        <form:errors path="description" cssClass="error"/>
    </form:label>
    <form:textarea path="description"/><br/>

    <div class="buttons">
        <button type="submit"><spring:message code="${btn}"/></button>
    </div>
</form:form> 