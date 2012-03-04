<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@page trimDirectiveWhitespaces="true" %>
<h2>${category.name}</h2>

<c:choose>
    <c:when test="${ empty products}">
        <spring:message code="product.list.empty"/>
    </c:when>
    <c:otherwise>
        <table>
            <tr>
                <th><spring:message code="product.name"/></th>
                <th><spring:message code="product.price.vat"/></th>
                <th><spring:message code="product.amount"/></th>
                <sec:authorize ifAnyGranted="ROLE_ADMIN">
                    <th colspan="2">&nbsp;</th>
                </sec:authorize>
            </tr>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><a href="<c:url value="/product/detail/${product.id}" />">${product.name}</a></td>
                    <td>${product.price}</td>
                    <td>${product.amount}</td>
                    <sec:authorize ifAnyGranted="ROLE_ADMIN">
                        <td>
                            <a href="<c:url value="/admin/product/edit/${product.id}" />">
                                <spring:message code="link.edit"/>
                            </a>
                        </td>
                        <td>
                            <a href="<c:url value="/admin/product/delete/${product.id}" />">
                                <spring:message code="link.delete"/>
                            </a>
                        </td>
                    </sec:authorize>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>
