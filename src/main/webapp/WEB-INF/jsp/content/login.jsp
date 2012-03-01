<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page trimDirectiveWhitespaces="true" %>

<c:url value="/j_spring_security_check" var="formActionUrl"/>


<div>${SPRING_SECURITY_LAST_EXCEPTION.message}</div>
<form id="loginForm" method="post" name="f" action="${formActionUrl}">
    <label for="login">
        <spring:message code="customer.label.email"/>
    </label>
    <input type="text" id="login" name="j_username"/><br/>

    <label for="password">
        <spring:message code="customer.label.password"/>
    </label>
    <input type="password" id="password" name="j_password"/>

    <input type="submit" name="submit" value="<spring:message code="button.login" />"/>
</form>