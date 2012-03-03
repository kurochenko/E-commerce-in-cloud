<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page trimDirectiveWhitespaces="true" %>

<p><spring:message code="product.delete.question" arguments="${product.name}"/></p><br/>
<c:url value="/admin/product/delete" var="formActionUrl"/>
<form:form method="post" action="${formActionUrl}" modelAttribute="product">
    <form:hidden path="id"/>
    <a href="<c:url value="/product/detail/${product.id}" />">
        <spring:message code="btn.no"/>
    </a>
    <input type="submit" value="<spring:message code="btn.yes"/>"/>
</form:form>