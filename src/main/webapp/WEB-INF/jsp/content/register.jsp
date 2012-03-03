<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page trimDirectiveWhitespaces="true" %>

<c:url value="/register" var="formActionUrl"/>
<form:form method="post" action="${formActionUrl}" modelAttribute="user">

    <form:hidden path="id"/>

    <form:label path="email">
        <spring:message code="customer.label.email"/>
    </form:label>
    <form:input path="email"/>
    <form:errors path="email"/><br/>

    <form:label path="password">
        <spring:message code="customer.label.password"/>
    </form:label>
    <form:password path="password"/>
    <form:errors path="password"/><br/>


    <form:label path="name">
        <spring:message code="customer.label.name"/>
    </form:label>
    <form:input path="name"/>
    <form:errors path="name"/><br/>

    <%--<form:label path="confirmPassword">--%>
    <%--<spring:message code="user.form.confirmPassword.label"/>--%>
    <%--</form:label>--%>
    <%--<form:password path="confirmPassword" />--%>
    <%--<form:errors path="confirmPassword" /><br />--%>

    <form:label path="city">
        <spring:message code="customer.label.city"/>
    </form:label>
    <form:input path="city"/>
    <form:errors path="city"/><br/>

    <form:label path="street">
        <spring:message code="customer.label.street"/>
    </form:label>
    <form:input path="street"/>
    <form:errors path="street"/><br/>

    <form:label path="zipCode">
        <spring:message code="customer.label.zipCode"/>
    </form:label>
    <form:input path="zipCode"/>
    <form:errors path="zipCode"/><br/>

    <div class="buttons">
        <button type="submit"><spring:message code="form.register"/></button>
            <%--<input type="submit" value=""/>--%>
    </div>
</form:form>