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
    <link rel="icon" type="image/png" href="<c:url value="/image/favicon.png" />"/>
</head>

<body>
<div id="container">
    <div id="header">
        <ul class="logreg">
            <sec:authorize ifNotGranted="ROLE_LOGGED">
                <c:url value="/login" var="loginUrl"/>
                <c:url value="/register" var="registerUrl"/>
                <li>
                    <a href="${registerUrl}"><spring:message code="link.register"/></a> / <a
                        href="${loginUrl}"><spring:message code="link.login"/></a>
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
        </ul>
        <h1><a href="<c:url value="/" />">E-commerce</a> - <spring:message code="${tilesTitle}"/></h1>


    </div>
    <div id="nav">
        <tiles:insertAttribute name="menu"/>
    </div>

    <div id="content-wrapper">
        <div id="content">
            <tiles:insertAttribute name="body"/>
        </div>
        <div id="side-menu">
            <tiles:insertAttribute name="cart"/>
            <sec:authorize ifAnyGranted="ROLE_ADMIN">
                <h3><spring:message code="admin.menu.title"/>:</h3>
                <ul>
                    <c:url value="/admin/category/list" var="listCategoryUrl"/>
                    <c:url value="/admin/vat/list" var="listVatUrl"/>
                    <c:url value="/admin/product/create" var="createProductUrl"/>
                    <c:url value="/admin/user/list" var="listUserUrl"/>
                    <c:url value="/admin/delivery/list" var="deliveryListUrl"/>
                    <c:url value="/admin/payment/list" var="paymentTypeListUrl"/>
                    <li>
                        <a href="${listCategoryUrl}"><spring:message code="link.category.list"/></a>
                    </li>
                    <li>
                        <a href="${listVatUrl}"><spring:message code="link.vat.list"/></a>
                    </li>
                    <li>
                        <a href="${createProductUrl}"><spring:message code="link.product.create"/></a>
                    </li>
                    <li>
                        <a href="${listUserUrl}"><spring:message code="link.customer.list"/></a>
                    </li>
                    <li>
                        <a href="${deliveryListUrl}"><spring:message code="link.delivery.list"/></a>
                    </li>
                    <li>
                        <a href="${paymentTypeListUrl}"><spring:message code="link.payment.list"/></a>
                    </li>
                </ul>
            </sec:authorize>
        </div>
    </div>

</div>
<div id="footer">
    <div class="text-wrapper">
        e-commerce in cloud
    </div>
</div>

</body>
</html>