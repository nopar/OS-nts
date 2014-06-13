<?xml version="1.0" encoding="UTF-8" ?>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Zoznam štátov</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="shortcut icon" type="image/x-icon" href="<cor:url value='/resources/img/favicon.ico'/>" />
        <link href="${pageContext.request.contextPath}/resources/css/layout.css" rel="stylesheet" type="text/css"/>

        <cor:choose>
            <cor:when test="${not empty pageContext.request.userPrincipal}">
                <!--JE LOGNUTY-->
                <cor:choose>
                    <cor:when test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
                        <!--je-->
                        <link href="${pageContext.request.contextPath}/resources/css/menu_admin.css" rel="stylesheet" type="text/css"/>
                    </cor:when>
                    <cor:otherwise>
                    </cor:otherwise>
                </cor:choose>         

                <cor:choose>
                    <cor:when test="${pageContext.request.isUserInRole('ROLE_LEKAR')}">
                        <!--je-->
                        <link href="${pageContext.request.contextPath}/resources/css/menu_lekar.css" rel="stylesheet" type="text/css"/>
                    </cor:when>
                    <cor:otherwise>
                    </cor:otherwise>
                </cor:choose>


                <cor:choose>
                    <cor:when test="${pageContext.request.isUserInRole('ROLE_DARCA')}">
                        <!--je-->
                        <link href="${pageContext.request.contextPath}/resources/css/menu_darca.css" rel="stylesheet" type="text/css"/>
                    </cor:when>
                    <cor:otherwise>
                    </cor:otherwise>
                </cor:choose>

            </cor:when>
            <cor:otherwise>
                <!--ANNONYMOUS-->
                <link href="${pageContext.request.contextPath}/resources/css/menu.css" rel="stylesheet" type="text/css"/>
            </cor:otherwise>
        </cor:choose>
                
            <style>
                th{
                    color: #00B4FF;
                }
            </style>
    </head>
        
    <body onclick="posun(3)">
        <script src="http://maps.google.com/maps/api/js?sensor=false"></script>
        
         <cor:choose>
                <cor:when test="${not empty pageContext.request.userPrincipal}">
                    <!--JE LOGNUTY-->
                    <cor:choose>
                        <cor:when test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
                            <!--je-->
                            <jsp:include flush="true" page="/WEB-INF/pages/menu/menu_admin_logged.jsp"></jsp:include> 
                        </cor:when>
                        <cor:otherwise>
                        </cor:otherwise>
                    </cor:choose>         

                    <cor:choose>
                        <cor:when test="${pageContext.request.isUserInRole('ROLE_LEKAR')}">
                            <!--je-->
                            <jsp:include flush="true" page="/WEB-INF/pages/menu/menu_lekar_logged.jsp"></jsp:include> 
                        </cor:when>
                        <cor:otherwise>
                        </cor:otherwise>
                    </cor:choose>


                    <cor:choose>
                        <cor:when test="${pageContext.request.isUserInRole('ROLE_DARCA')}">
                            <!--je-->
                            <jsp:include flush="true" page="/WEB-INF/pages/menu/menu_darca_logged.jsp"></jsp:include> 
                        </cor:when>
                        <cor:otherwise>
                        </cor:otherwise>
                    </cor:choose>

                </cor:when>
                <cor:otherwise>
                    <!--ANNONYMOUS-->
                    <jsp:include flush="true" page="/WEB-INF/pages/menu/menu_non_logged.jsp"></jsp:include> 
                </cor:otherwise>
            </cor:choose>


                
        <div class="container">
            
                    
        <h1>Zoznam štátov</h1>
        
        <button onclick="location.href = '${pageContext.request.contextPath}/logged/admin/stat/add.html'">
            Pridať štát
        </button></br></br>

    <cor:if  test="${!empty stats}">
    <table border="1px" cellpadding="0" cellspacing="0" >
    <thead>
        <tr>
            <th width="15%">STAT</th>
            <th width="10%">SKRATKA</th>
            <th width="10%"></th>
        </tr>
    </thead>
    <tbody align="center">
        <cor:forEach var="statik" items="${stats}">
            <tr>
                <td style="padding-left: 10px;" align="left">${statik.stat}</td>
                <td>${statik.skratka}</td>
                <td>
                    <div id="crud_icon_block">
                        <input type="image"
                               src="${pageContext.request.contextPath}/resources/img/edit.png"
                               alt="Edituj štát"
                               class="crud_icon"
                               onclick="location.href = '${pageContext.request.contextPath}/logged/admin/stat/edit/${statik.idStat}.html'"/>

                        <input type="image"
                               src="${pageContext.request.contextPath}/resources/img/delete.png"
                               alt="Zmaž štát"
                               class="crud_icon"
                               onclick="location.href ='${pageContext.request.contextPath}/logged/admin/stat/delete/${statik.idStat}.html'"/>
                    </div>
                </td>
            </tr>
        </cor:forEach>
    </tbody>
    </table>
    </cor:if>

        <p>
            <button onclick="location.href = '${pageContext.request.contextPath}/'">
                Domov
            </button>

            <INPUT Type="button" VALUE="Naspäť" onClick="history.go(-1);
                    return true;"></INPUT>
        </p>
    </div>
    </body>
</html>