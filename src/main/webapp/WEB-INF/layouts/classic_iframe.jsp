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
<!-- BEGIN CONTAINER -->
<div class="container-fluid" style="padding:0px;!important;">
    <div class="page-content page-content-popup" style="margin:0px;!important;">
        <div class="page-fixed-main-content" style="padding:0px;!important;">
            <!-- BEGIN PAGE BASE CONTENT -->
            <div class="row">
                <div class="col-lg-12">
                    <!-- BEGIN SAMPLE TABLE PORTLET-->
                    <div class="portlet light bordered" style="padding:0px;!important;">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="icon-social-dribbble font-purple-soft"></i>
                                <span class="caption-subject font-purple-soft bold uppercase"><tiles:insertAttribute name="businessJS"/></span>
                            </div>
                            <div class="actions">
                                <a class="btn btn-circle btn-icon-only btn-default" href="javascript:;">
                                    <i class="icon-plus"></i>
                                </a>
                                <a class="btn btn-circle btn-icon-only btn-default" href="javascript:;">
                                    <i class="icon-wrench"></i>
                                </a>
                                <a class="btn btn-circle btn-icon-only btn-default" href="javascript:;">
                                    <i class="icon-trash"></i>
                                </a>
                            </div>
                        </div>
                        <div class="portlet-body"> <tiles:insertAttribute name="body"/></div>

                    </div>

                    <!-- END SAMPLE TABLE PORTLET-->
                </div>
            </div>
            <!-- END PAGE BASE CONTENT -->
        </div>

    </div>
</div>
<!-- END CONTAINER -->

<script type="text/javascript"
        src="<c:url value='/plugins-js/require.js' />"
        data-main="<c:url value='/plugins-js/' /><tiles:insertAttribute name="businessJS"/>"></script>


</body>
</html>