<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page trimDirectiveWhitespaces="true" %>

<c:url value="/admin/category/create" var="createCategoryUrl"/>

<c:choose>
    <c:when test="${empty categories}">
        <spring:message code="category.msg.empty"/>&nbsp;<a href="${createCategoryUrl}"><spring:message
            code="link.category.create"/></a>
    </c:when>
    <c:otherwise>
        <div class="centered">
            <table>
                <tr>
                    <th><spring:message code="category.name"/></th>
                    <th colspan="2"><a href="${createCategoryUrl}"><spring:message code="link.category.create"/></a>
                    </th>
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
        </div>
    </c:otherwise>
</c:choose>
