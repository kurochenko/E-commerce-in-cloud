<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page trimDirectiveWhitespaces="true" %>

<c:url value="/admin/delivery/create" var="createDeliveryUrl"/>

<c:choose>
    <c:when test="${empty deliveries}">
        <spring:message code="delivery.msg.empty"/>&nbsp;<a href="${createDeliveryUrl}"><spring:message
            code="link.delivery.create"/></a>
    </c:when>
    <c:otherwise>
        <div class="centered">
            <table>
                <tr>
                    <th><spring:message code="delivery.name"/></th>
                    <th><spring:message code="delivery.price"/></th>
                    <th colspan="2"><a href="${createDeliveryUrl}"><spring:message code="link.delivery.create"/></a>
                    </th>
                </tr>
                <c:forEach items="${deliveries}" var="delivery">
                    <tr>
                        <td>${delivery.name}</td>
                        <td><spring:eval expression="${delivery.price}"/></td>
                        <td><a href="<c:url value="/admin/delivery/edit/${delivery.id}" />"><spring:message
                                code="link.edit"/></a></td>
                        <td><a href="<c:url value="/admin/delivery/delete/${delivery.id}" />"><spring:message
                                code="link.delete"/></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:otherwise>
</c:choose>
