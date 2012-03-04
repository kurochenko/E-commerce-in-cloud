<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page trimDirectiveWhitespaces="true" %>

<c:choose>
    <c:when test="${!empty errorMsg}">
        <spring:message code="${errorMsg}" arguments="${vatObject.vat}"/>
    </c:when>
    <c:otherwise>
        <c:url value="/admin/vat/delete" var="formActionUrl"/>
        <form:form method="post" action="${formActionUrl}" modelAttribute="vatObject">
            <p><spring:message code="vat.delete.question" arguments="${vatObject.vat}"/></p>
            <form:hidden path="id"/>
            <div class="buttons">
                <a href="<c:url value="/admin/vat/list" />">
                    <spring:message code="btn.no"/>
                </a>
                <button type="submit"><spring:message code="btn.yes"/></button>
            </div>
        </form:form>
    </c:otherwise>
</c:choose>
