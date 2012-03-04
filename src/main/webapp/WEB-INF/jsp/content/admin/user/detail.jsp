<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page trimDirectiveWhitespaces="true" %>

<c:choose>
    <c:when test="${empty customer}">
        <spring:message code="customer.not.found"/>
    </c:when>
    <c:otherwise>
        <a href="<c:url value="/admin/user/list" />">
            <spring:message code="customer.detail.back.link"/>
        </a>
        <table class="detail">
            <tr>
                <th><spring:message code="customer.label.name"/>:</th>
                <td>${customer.name}</td>
            </tr>
            <tr>
                <th><spring:message code="customer.label.email"/>:</th>
                <td>${customer.email}</td>
            </tr>
            <tr>
                <th><spring:message code="customer.label.city"/>:</th>
                <td>${customer.city}</td>
            </tr>
            <tr>
                <th><spring:message code="customer.label.street"/>:</th>
                <td>${customer.street}</td>
            </tr>
            <tr>
                <th><spring:message code="customer.label.zipCode"/>:</th>
                <td>${customer.zipCode}</td>
            </tr>
            <tr>
                <th><spring:message code="customer.label.created"/>:</th>
                <td>${customer.created}</td>
            </tr>
        </table>

        <c:url value="/admin/user/edit" var="actionUrl"/>
        <form:form method="post" modelAttribute="customer" action="${actionUrl}">
            <form:hidden path="id"/>
            <form:label path="privileges">
                <spring:message code="customer.privileges"/>:
                <form:errors path="privileges" cssClass="error"/>
            </form:label>
            <form:checkboxes path="privileges" items="${privilegesObject}" itemValue="id" itemLabel="name"
                             cssClass="chckbx"/>
            <br/>

            <div class="buttons">
                <button type="submit" class="full"><spring:message code="btn.update"/></button>
            </div>

        </form:form>
    </c:otherwise>
</c:choose>