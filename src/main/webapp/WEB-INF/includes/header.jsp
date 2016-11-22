<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <c:url value="/webjars/jquery/2.1.4/jquery.min.js" var="jquery" />
    <script src="${jquery}"></script>
    <c:url value="/webjars/bootstrap/3.3.4/js/bootstrap.js" var="bootstrap" />
    <script src="${bootstrap}"></script>
    <c:url value="/static/js/common.js" var="common" />
    <script src="${common}"></script>

    <%--<c:url value="/webjars/bootstrap/3.3.4/css/bootstrap.min.css" var="bootstrap" />--%>
    <%--<link href="${bootstrap}" rel="stylesheet" media="screen"/>--%>

    <c:url value="/static/css/bootstrap_themes/bootstrap_${theme}.min.css" var="bootstrap_theme" />
    <link href="${bootstrap_theme}" rel="stylesheet" media="screen"/>

    <c:url value="/static/css/astonengineer.css" var="bootstrap_custom" />
    <link href="${bootstrap_custom}" rel="stylesheet" media="screen"/>


    <title>Aston Technologies HR Application</title>
</head>
<body>

<div class="container">