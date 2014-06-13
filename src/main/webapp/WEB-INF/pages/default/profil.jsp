<%-- 
    Document   : profil
    Created on : 29-Apr-2014, 20:41:35
    Author     : nox
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cor" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page session="true"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notifikácie</title>

        <link rel="shortcut icon" type="image/x-icon" href="<cor:url value='/resources/img/favicon.ico'/>" />
        <link href="${pageContext.request.contextPath}/resources/css/layout.css" rel="stylesheet" type="text/css"/>
        
        <style>
            th{
                color: #00B4FF;
            }
        </style>

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

        <script src="${pageContext.request.contextPath}/resources/js/geoLocation.js" type="text/javascript"></script> 

    </head>

    <body>
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

            <h1>Notifikácie</h1>
            <div id="tmp"></div>
            


            <cor:set var="count" value="${0}"/>
            
            <script>
                function zmena(cislo){
                    
                    if(cislo == 1){
                        if(document.getElementById("mojeOdbery_txt").value == "true"){
                            document.getElementById("mojeOdbery_txt").value = "false";
                        }else{
                            document.getElementById("mojeOdbery_txt").value = "true";
                        }
                    }
                    
                    if(cislo == 2){
                        if(document.getElementById("vyjazdoveOdbery_txt").value == "true"){
                            document.getElementById("vyjazdoveOdbery_txt").value = "false";
                        }else{
                            document.getElementById("vyjazdoveOdbery_txt").value = "true";
                        }
                    }
                    
                    if(cislo == 3){
                        if(document.getElementById("urgentnePripady_txt").value == "true"){
                            document.getElementById("urgentnePripady_txt").value = "false";
                        }else{
                            document.getElementById("urgentnePripady_txt").value = "true";
                        }
                    }
                    
                    if(cislo == 4){
                        if(document.getElementById("kraj_txt").value == "true"){
                            document.getElementById("kraj_txt").value = "false";
                        }else{
                            document.getElementById("kraj_txt").value = "true";
                        }
                    }
                }                
                //idNastavenia object
            </script>
            
            
           
            
            
            
            
            <cor:if  test="${!empty object}">
            <form:form method="POST" commandName="object" action="${pageContext.request.contextPath}/logged/profil/${object.idNastavenie}">
                <table  border="1px" cellpadding="0" cellspacing="0" >
                    <thead>
                        <tr>
                            <th width="50%">NASTAVENIE</th>
                            <th width="20%">ZAPNUTE / VYPNUTE</th>

                        </tr>
                    </thead>
                    <tbody align="center">
                        <tr>
                            
                            <td><form:input type="hidden" path="idNastavenie" /></td>
                        </tr>

                        <tr>
                            <td style="padding-left: 15px;" align="left">Kedy môžem darovať:</td>
                            <td><form:input type="hidden" path="mojeOdbery" id="mojeOdbery_txt"/>
                                <input type="checkbox" name="odber" value="${object.mojeOdbery}" onchange="zmena('1')"
                                   <cor:if  test="${object.mojeOdbery == 'true'}">checked="checked"</cor:if>
                                   <cor:if  test="${object.mojeOdbery == 'false'}"></cor:if>
                                       >
                            </td>
                        </tr>
                        <tr>
                            <td style="padding-left: 15px;" align="left">Výjazdové odbery:</td>
                            <td><form:input type="hidden" path="vyjazdoveOdbery" id="vyjazdoveOdbery_txt"/>
                            <input type="checkbox" name="odber" value="${object.vyjazdoveOdbery}"  onchange="zmena('2')"
                                   <cor:if  test="${object.vyjazdoveOdbery == 'true'}">checked="checked"</cor:if>
                                   <cor:if  test="${object.vyjazdoveOdbery == 'false'}"></cor:if>
                                       >
                        </td>
                        </tr>
                        <tr>
                            <td style="padding-left: 15px;" align="left">Urgentné prípady:</td>
                            <td><form:input type="hidden" path="urgentnePripady" id="urgentnePripady_txt"/>
                            <input type="checkbox" name="odber" value="${object.urgentnePripady}"  onchange="zmena('3')"
                                   <cor:if  test="${object.urgentnePripady == 'true'}">checked="checked"</cor:if>
                                   <cor:if  test="${object.urgentnePripady == 'false'}"></cor:if>
                                       >
                        </td>
                        </tr>
                        <tr>
                            <td style="padding-left: 15px;" align="left">Len z môjho kraja:</td>
                            <td><form:input type="hidden" path="kraj" id="kraj_txt"/>
                            <input type="checkbox" name="kraj" value="${object.kraj}"  onchange="zmena('4')"
                                   <cor:if  test="${object.kraj == 'true'}">checked="checked"</cor:if>
                                   <cor:if  test="${object.kraj == 'false'}"></cor:if>
                                       >
                        </td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Nastav" /></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </form:form>
            </cor:if>
            
            
            <p id="x"></p>                
            <br>
            <div id="mapholder"></div>
        </div>
    </body>
</html>
