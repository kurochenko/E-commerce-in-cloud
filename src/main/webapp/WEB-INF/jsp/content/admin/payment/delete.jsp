<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page trimDirectiveWhitespaces="true" %>

<c:choose>
    <c:when test="${!empty errorMsg}">
        <spring:message code="${errorMsg}" arguments="${payment.name}"/>
    </c:when>
    <c:otherwise>

        <c:url value="/admin/payment/delete" var="formActionUrl"/>
        <form:form method="post" action="${formActionUrl}" modelAttribute="payment">
            <p><spring:message code="payment.delete.question" arguments="${payment.name}"/></p>
            <form:hidden path="id"/>

            <div class="buttons">
                <a href="<c:url value="/admin/payment/list" />" class="half">
                    <spring:message code="btn.no"/>
                </a>
                <button type="submit" class="half"><spring:message code="btn.yes"/></button>
            </div>

        </form:form>
    </c:otherwise>
</c:choose>

