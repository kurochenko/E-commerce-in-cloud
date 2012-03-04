<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@page trimDirectiveWhitespaces="true" %>

<c:choose>
    <c:when test="${empty product}">
        <spring:message code="product.not.found"/>
    </c:when>
    <c:otherwise>
        <a href="<c:url value="/category/${product.category.id}/list" />">
            <spring:message code="product.detail.back.link" arguments="${product.category.name}"/>
        </a>
        <table class="detail">
            <tr>
                <th><spring:message code="product.name"/>:</th>
                <td>${product.name}</td>
            </tr>
            <tr>
                <th><spring:message code="product.price.vat"/> (<spring:message code="product.vat"/>):</th>
                <td>${vatPrice} (${product.vat.vat}&nbsp;%)</td>
            </tr>
            <tr>
                <th><spring:message code="product.price.novat"/>:</th>
                <td>${product.price}</td>
            </tr>
            <tr>
                <th><spring:message code="product.amount"/>:</th>
                <td>${product.amount}</td>
            </tr>
            <tr>
                <th><spring:message code="product.category"/>:</th>
                <td>${product.category.name}</td>
            </tr>
            <tr>
                <th><spring:message code="product.description"/>:</th>
                <td>${product.description}</td>
            </tr>
            <tr>
                <sec:authorize ifAnyGranted="ROLE_ADMIN">
                    <td class="edit">
                        <div class="buttons">
                            <a href="<c:url value="/admin/product/edit/${product.id}" />">
                                <spring:message code="link.edit"/>
                            </a>
                        </div>
                    </td>
                    <td>
                        <div class="buttons">
                            <a href="<c:url value="/admin/product/delete/${product.id}" />">
                                <spring:message code="link.delete"/>
                            </a>
                        </div>
                    </td>
                </sec:authorize>
            </tr>
        </table>
    </c:otherwise>
</c:choose>