<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page trimDirectiveWhitespaces="true" %>

<c:choose>
    <c:when test="${empty vats}">
        <spring:message code="vat.msg.empty"/>. <a href="<c:url value="/admin/vat/create" />"><spring:message
            code="link.vat.create"/></a>
    </c:when>
    <c:otherwise>
        <a href="<c:url value="/admin/vat/create" />"><spring:message code="link.vat.create"/></a>
        <table>
            <tr>
                <td><spring:message code="vat.value"/></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
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
