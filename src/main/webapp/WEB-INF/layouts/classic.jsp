<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib
        uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib
        uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib
        prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib
        prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib
        prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="X-UA-Compatible" content="IE=8;FF=3;OtherUA=4"/>
    <title><spring:message code="common.title.site"/></title>
</head>
<body>
<tiles:insertAttribute name="body"/>
<script type="text/javascript"
        src="<c:url value='/plugins-js/require.js' />"
        data-main="<c:url value='/plugins-js/' /><tiles:insertAttribute name="businessJS"/>"></script>

<tiles:insertAttribute name="footer"/>
</body>
</html>