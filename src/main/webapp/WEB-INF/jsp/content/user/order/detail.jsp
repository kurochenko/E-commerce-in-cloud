<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@page trimDirectiveWhitespaces="true" %>

<h2>#${order.id}, ${order.created}</h2>
<a href="/order/list"><spring:message code="link.back"/></a>
<table>
    <tr>
        <th><spring:message code="cart.product"/></th>
        <th><spring:message code="product.category"/></th>
        <th><spring:message code="cart.amount"/></th>
        <th><spring:message code="product.price"/></th>
        <th><spring:message code="product.vat"/></th>
        <th><spring:message code="product.price.vat"/></th>
        <th>&nbsp;</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>
                <a href="<c:url value="/product/detail/${product.product.id}" />">
                        ${product.product.name}
                </a>
            </td>
            <td>${product.product.category.name}</td>
            <td><spring:eval expression="${product.amount}"/></td>
            <td><spring:eval expression="${product.product.price}"/></td>
            <td><spring:eval expression="${product.product.vat.vat}"/></td>
            <td><spring:eval
                    expression="${product.product.price}+(${product.product.price}*(${product.product.vat.vat}/100))"/></td>
        </tr>
    </c:forEach>
    <tr>
        <th colspan="6">&nbsp;</th>
    </tr>
    <tr>
        <td><spring:message code="delivery.name"/></td>
        <td>${order.deliveryType.name}</td>
        <td>&nbsp;</td>
        <td><spring:eval expression="${order.deliveryType.price}"/></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <th colspan="6">&nbsp;</th>
    </tr>
    <tr class="emphasized">
        <td><spring:message code="cart.total"/>:</td>
        <td>&nbsp;</td>
        <td><spring:eval expression="${stats.amount}"/></td>
        <td><spring:eval expression="${stats.price} + ${order.deliveryType.price}"/></td>
        <td>&nbsp;</td>
        <td><spring:eval expression="${stats.priceVat} + ${order.deliveryType.price}"/></td>
    </tr>
    <sec:authorize ifAnyGranted="ROLE_ADMIN">
        <c:if test="${empty order.attended}">
            <tr>
                <td colspan="6">
                    <div class="buttons">
                        <a href="<c:url value="/admin/order/attend/${order.id}" />" class="half">
                            <spring:message code="order.attend"/>
                        </a>
                    </div>
                </td>
            </tr>
        </c:if>
    </sec:authorize>
</table>
