<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page trimDirectiveWhitespaces="true" %>

<h2><spring:message code="order.old"/></h2>
<table>
    <tr>
        <th>&nbsp;</th>
        <th><spring:message code="order.customer"/></th>
        <th><spring:message code="order.created"/></th>
        <th><spring:message code="delivery.name"/></th>
        <th><spring:message code="payment.name"/></th>
    </tr>
    <c:forEach items="${orders}" var="order">
        <c:url value="/order/detail/${order.id}" var="orderUrl"/>
        <c:url value="/admin/user/detail/${order.customer.id}" var="customerUrl"/>
        <tr>
            <td><a href="${orderUrl}">#${order.id}</a></td>
            <td><a href="${customerUrl}">${order.customer.email}</a></td>
            <td><a href="${orderUrl}">${order.created}</a></td>
            <td>${order.deliveryType.name}</td>
            <td>${order.paymentType.name}</td>
        </tr>
    </c:forEach>
</table>