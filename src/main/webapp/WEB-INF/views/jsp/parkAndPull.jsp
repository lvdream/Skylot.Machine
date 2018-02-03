<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
           prefix="tilesx" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib
        prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Title</title>
    <script src='<c:url value="/plugins-js/jquery/jquery-1.9.0.min.js" />'></script>
</head>
<body>
    <label>请输入车牌号：</label><input id="numCar" name="numCar" type="text"/>
    <button type="button" onclick="parking()">停车</button>
    <button type="button" onclick="pulling()">取车</button>
</body>
<script>

    function parking(){
        $.post("${pageContext.request.contextPath}/index/parking",{numCar : $("#numCar").val()},function(result1){
            if (result1 == 0){
                alert("没有可用车位！");
            }else{
                alert("停车成功");
            }
        });
    }

    function pulling(){
        $.post("${pageContext.request.contextPath}/index/pulling",{numCar : $("#numCar").val()},function(result2){
            if (result2 == 0){
                alert("找不到该车");
            }else{
                alert("取车成功");
            }
        })
    }
</script>
</html>
