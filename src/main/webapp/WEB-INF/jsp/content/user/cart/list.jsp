<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page trimDirectiveWhitespaces="true" %>

<c:choose>
    <c:when test="${empty carts}">
        <spring:message code="cart.empty"/>
    </c:when>
    <c:otherwise>
        <table class="cart-table">
            <tr>
                <th><spring:message code="cart.product"/></th>
                <th><spring:message code="product.category"/></th>
                <th><spring:message code="cart.amount"/></th>
                <th><spring:message code="product.price"/></th>
                <th><spring:message code="product.vat"/></th>
                <th><spring:message code="product.price.vat"/></th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${carts}" var="cart">
                <tr>
                    <td>
                        <a href="<c:url value="/product/detail/${cart.product.id}" />">
                                ${cart.product.name}
                        </a>
                    </td>
                    <td>${cart.product.category.name}</td>
                    <td><spring:eval expression="${cart.amount}"/></td>
                    <td><spring:eval expression="${cart.product.price}"/></td>
                    <td><spring:eval expression="${cart.product.vat.vat}"/></td>
                    <td><spring:eval
                            expression="${cart.product.price}+(${cart.product.price}*(${cart.product.vat.vat}/100))"/></td>
                    <td class="btns">
                        <div class="buttons">
                            <a href="<c:url value="/cart/amount/inc/${cart.product.id}" />" class="half">
                                <spring:message code="cart.add"/>
                            </a>
                            <a href="<c:url value="/cart/amount/dec/${cart.product.id}" />" class="half">
                                <spring:message code="cart.remove"/>
                            </a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <tr class="emphasized">
                <td><spring:message code="cart.total"/>:</td>
                <td>&nbsp;</td>
                <td><spring:eval expression="${cartStats.amount}"/></td>
                <td><spring:eval expression="${cartStats.price}"/></td>
                <td>&nbsp;</td>
                <td><spring:eval expression="${cartStats.priceVat}"/></td>
                <td>&nbsp;</td>
            </tr>
        </table>
        <c:url value="/cart/order" var="saveOrderUrl"/>
        <form:form method="post" action="${saveOrderUrl}" modelAttribute="order">
            <form:label path="deliveryType">
                <spring:message code="delivery.name"/><em>*</em>:
                <form:errors path="deliveryType" cssClass="error"/>
            </form:label>
            <form:select path="deliveryType" items="${deliveryTypes}" itemLabel="name" itemValue="id"/>

            <form:label path="paymentType">
                <spring:message code="payment.name"/><em>*</em>:
                <form:errors path="paymentType" cssClass="error"/>
            </form:label>
            <form:select path="paymentType" items="${paymentTypes}" itemLabel="name" itemValue="id"/>

            <div class="buttons">
                <button type="submit" class="full">
                    <spring:message code="cart.order.create"/>
                </button>
            </div>
        </form:form>
    </c:otherwise>
</c:choose>
