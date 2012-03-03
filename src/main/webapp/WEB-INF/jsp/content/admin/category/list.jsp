<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page trimDirectiveWhitespaces="true" %>

<c:choose>
    <c:when test="${empty categories}">
        <spring:message code="category.msg.empty"/>.&nbsp;<a href="<c:url
            value="/admin/category/create"/>"><spring:message code="link.category.create"/></a>
    </c:when>
    <c:otherwise>
        <a href="<c:url value="/admin/category/create" />"><spring:message code="link.category.create"/></a>
        <table>
            <tr>
                <td><spring:message code="category.name"/></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <c:forEach items="${categories}" var="category">
                <tr>
                    <td>${category.name}</td>
                    <td><a href="<c:url value="/admin/category/edit/${category.id}" />"><spring:message
                            code="link.edit"/></a></td>
                    <td><a href="<c:url value="/admin/category/delete/${category.id}" />"><spring:message
                            code="link.delete"/></a></td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>
