<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page trimDirectiveWhitespaces="true" %>

<c:set var="tilesTitle">
    <tiles:insertAttribute name="title" ignore="true"/>
</c:set>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>E-commerce | <spring:message code="${tilesTitle}"/></title>
</head>

<body>
<div class="container">
    <h1>E-commerce - <spring:message code="${tilesTitle}"/></h1>
    <tiles:insertAttribute name="body"/>
</div>

</body>
</html>