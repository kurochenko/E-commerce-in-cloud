<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page trimDirectiveWhitespaces="true" %>

<c:url value="/admin/vat/create" var="createVatURL"/>
<c:choose>
    <c:when test="${empty vats}">
        <spring:message code="vat.msg.empty"/>. <a href="${createVatURL}"><spring:message
            code="link.vat.create"/></a>
    </c:when>
    <c:otherwise>

        <table>
            <tr>
                <th><spring:message code="vat.value"/></th>
                <th colspan="2"><a href="${createVatURL}"><spring:message code="link.vat.create"/></a></th>
            </tr>
            <c:forEach items="${vats}" var="vat">
                <tr>
                    <td>${vat.vat}</td>
                    <td><a href="<c:url value="/admin/vat/edit/${vat.id}" />"><spring:message
                            code="link.edit"/></a></td>
                    <td><a href="<c:url value="/admin/vat/delete/${vat.id}" />"><spring:message
                            code="link.delete"/></a></td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>
