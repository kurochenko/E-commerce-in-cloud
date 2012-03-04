<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page trimDirectiveWhitespaces="true" %>

<c:url value="/admin/payment/create" var="createDeliveryUrl"/>

<c:choose>
    <c:when test="${empty payments}">
        <spring:message code="payment.msg.empty"/>&nbsp;<a href="${createDeliveryUrl}"><spring:message
            code="link.payment.create"/></a>
    </c:when>
    <c:otherwise>
        <div class="centered">
            <table>
                <tr>
                    <th><spring:message code="payment.name"/></th>
                    <th colspan="2"><a href="${createDeliveryUrl}"><spring:message code="link.payment.create"/></a>
                    </th>
                </tr>
                <c:forEach items="${payments}" var="payment">
                    <tr>
                        <td>${payment.name}</td>
                        <td><a href="<c:url value="/admin/payment/edit/${payment.id}" />"><spring:message
                                code="link.edit"/></a></td>
                        <td><a href="<c:url value="/admin/payment/delete/${payment.id}" />"><spring:message
                                code="link.delete"/></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:otherwise>
</c:choose>
