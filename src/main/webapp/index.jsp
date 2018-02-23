<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib
        prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<!--
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.7
Version: 4.7
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Dribbble: www.dribbble.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
Renew Support: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->

<head>
    <meta charset="utf-8"/>
    <title>Fangda | Skylot-Admin-Console</title>
    <script src='<c:url value="/plugins-js/jquery/jquery-1.9.0.min.js" />'></script>
<body class=" login">
<div id="log-container" style="height: 600px; overflow-y: scroll; background: #333; color: #aaa; padding: 10px;">
    <div>
    </div>
</div>
<script>
    $(document).ready(function () {
        // 指定websocket路径

//        var websocket = new WebSocket('ws://10.3.13.13:8080/skymachine/log');
        var websocket = new WebSocket('ws://192.168.10.2:8080/skymachine/log');
        websocket.onmessage = function (event) {
            // 接收服务端的实时日志并添加到HTML页面中
            $("#log-container div").append(event.data + "<p> </p>");
            // 滚动条滚动到最低部
            $("#log-container").scrollTop($("#log-container div").height() - $("#log-container").height());
        };
    });

</script>
</body>

</html>