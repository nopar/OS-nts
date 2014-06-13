<?xml version="1.0" encoding="UTF-8" ?>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cor" %>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html  lang="sk"
       xmlns="http://www.w3.org/1999/xhtml"
       xmlns:ui="http://java.sun.com/jsf/facelets"
       xmlns:h="http://java.sun.com/jsf/html">
    
    <head>
        <title>Role</title>
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

        <script src="${pageContext.request.contextPath}/resources/js/posuvacmenu.js" type="text/javascript"></script>
        <style>
            th{
                color: #00B4FF;
            }
        </style>
        
    </head>
    
    <body onload="posun(2)">
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
                
            <h1>Role</h1>
           

            <button onclick="location.href = '${pageContext.request.contextPath}/logged/admin/skupiny/add.html'">
                Pridať rolu
            </button></br></br>

            <cor:if  test="${!empty skupiny}">
                <table border="1px" cellpadding="0" cellspacing="0" >
                    <thead>
                        <tr>
                            <th width="15%">AUTORITA</th>
                            <th width="10%">SPECIALNE</th>
                            <th width="10%"></th>
                        </tr>
                    </thead>
                    <tbody align="center">
                        <cor:forEach var="skupina" items="${skupiny}">
                            <tr>
                                <td style="padding-left: 10px;" align="left">${skupina.autorita}</td>
                                <td>${skupina.specialne}</td>
                                <td>
                                    <div id="crud_icon_block">
                                        <input type="image"
                                               src="${pageContext.request.contextPath}/resources/img/edit.png"
                                               alt="Edituj skupinu"
                                               class="crud_icon"
                                               onclick="location.href = '${pageContext.request.contextPath}/logged/admin/skupiny/edit/${skupina.idGroup}.html'">


                                            <input type="image"
                                                   src="${pageContext.request.contextPath}/resources/img/delete.png"
                                                   alt="Zmaž skupinu"
                                                   class="crud_icon"
                                                   onclick="location.href ='${pageContext.request.contextPath}/logged/admin/skupiny/delete/${skupina.idGroup}.html'">
                                                </div>

                                                </td>
                                                </tr>
                                            </cor:forEach>
                    </tbody>
                </table>
            </cor:if>

            <p>
                <button onclick="location.href = '${pageContext.request.contextPath}/index.html'">
                    Domov
                </button>

                <INPUT Type="button" VALUE="Naspäť" onClick="history.go(-1);
                    return true;"></INPUT>
            </p>
                    
                  
                    
                 
      
<!--                    <cor:choose>
                    <cor:when test="${pageContext.request.userPrincipal.name == null}">
                        <h1>Prosím prihláste sa.</h1>
                    </cor:when>
                        <cor:otherwise>
                            <h1></h1>
                        </cor:otherwise>
                </cor:choose>
                    -->
                 
        </div>
    </body>
</html>