<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@page trimDirectiveWhitespaces="true" %>

<table>
    <tr>
        <th><spring:message code="customer.label.name"/></th>
        <th><spring:message code="customer.label.email"/></th>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td><a href="<c:url value="/admin/user/detail/${customer.id}" />">${customer.name}</a></td>
            <td>${customer.email}</td>
        </tr>
    </c:forEach>
</table>
