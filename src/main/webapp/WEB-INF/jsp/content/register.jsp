<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page trimDirectiveWhitespaces="true" %>

<c:url value="/register" var="formActionUrl"/>
<form:form method="post" action="${formActionUrl}" modelAttribute="user">

    <form:hidden path="id"/>

    <form:label path="email" cssClass="required">
        <spring:message code="customer.label.email"/><em>*</em>:
        <form:errors path="email" cssClass="error"/>
    </form:label>
    <form:input path="email"/><br/>

    <form:label path="password">
        <spring:message code="customer.label.password"/><em>*</em>:
        <form:errors path="password" cssClass="error"/>
    </form:label>
    <form:password path="password"/><br/>


    <form:label path="name">
        <spring:message code="customer.label.name"/><em>*</em>:
        <form:errors path="name" cssClass="error"/>
    </form:label>
    <form:input path="name"/><br/>

    <%--<form:label path="confirmPassword">--%>
    <%--<spring:message code="user.form.confirmPassword.label"/>--%>
    <%--</form:label>--%>
    <%--<form:password path="confirmPassword" />--%>
    <%--<form:errors path="confirmPassword" /><br />--%>

    <form:label path="city">
        <spring:message code="customer.label.city"/><em>*</em>:
        <form:errors path="city" cssClass="error"/>
    </form:label>
    <form:input path="city"/><br/>

    <form:label path="street">
        <spring:message code="customer.label.street"/><em>*</em>:
        <form:errors path="street" cssClass="error"/>
    </form:label>
    <form:input path="street"/><br/>

    <form:label path="zipCode">
        <spring:message code="customer.label.zipCode"/><em>*</em>:
        <form:errors path="zipCode" cssClass="error"/>
    </form:label>
    <form:input path="zipCode"/><br/>

    <div class="buttons">
        <button type="submit"><spring:message code="form.register"/></button>
    </div>
</form:form>