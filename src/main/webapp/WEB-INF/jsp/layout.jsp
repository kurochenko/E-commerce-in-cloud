<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@page trimDirectiveWhitespaces="true" %>

<c:set var="tilesTitle">
    <tiles:insertAttribute name="title" ignore="true"/>
</c:set>

<c:url value="/css/styles.css" var="cssUrl"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${cssUrl}" type="text/css"/>
    <title>E-commerce | <spring:message code="${tilesTitle}"/></title>
</head>

<body>
<div id="container">
    <h1>E-commerce - <spring:message code="${tilesTitle}"/></h1>

    <c:url value="/register" var="registerUrl"/>
    <ul>
        <sec:authorize ifAnyGranted="ROLE_ADMIN">
            <c:url value="/admin/category/list" var="listCategoryUrl"/>
            <c:url value="/admin/vat/list" var="listVatUrl"/>
            <c:url value="/admin/product/create" var="createProductUrl"/>
            <li>
                <a href="${listCategoryUrl}"><spring:message code="link.category.list"/></a>
            </li>
            <li>
                <a href="${listVatUrl}"><spring:message code="link.vat.list"/></a>
            </li>
            <li>
                <a href="${createProductUrl}"><spring:message code="link.product.create"/></a>
            </li>
        </sec:authorize>
        <sec:authorize ifAnyGranted="ROLE_LOGGED">
            <c:url value="/logout" var="logoutUrl"/>
            <li>
                <a href="${logoutUrl}">
                    <sec:authentication property="principal.username"/>
                    (<spring:message code="link.logout"/>)
                </a>
            </li>
        </sec:authorize>
        <sec:authorize ifNotGranted="ROLE_LOGGED">
            <c:url value="/login" var="loginUrl"/>
            <li>
                <a href="${loginUrl}"><spring:message code="link.login"/></a>
            </li>
        </sec:authorize>
        <li><a href="${registerUrl}"><spring:message code="link.register"/></a></li>
    </ul>
    <hr/>
    <tiles:insertAttribute name="menu"/>

    <tiles:insertAttribute name="body"/>
</div>

</body>
</html>