<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@page trimDirectiveWhitespaces="true" %>
<h3><spring:message code="cart.menu.title"/>:</h3>
<ul id="cart">
    <li><spring:message code="cart.product.count"/>: <spring:eval expression="${cartStats.amount}"/></li>
    <li><spring:message code="product.price"/>: <spring:eval expression="${cartStats.price}"/></li>
    <li><spring:message code="product.price.vat"/>: <spring:eval expression="${cartStats.priceVat}"/></li>
    <li><a href="<c:url value="/cart/list" />"><spring:message code="cart.show"/></a></li>
</ul>

