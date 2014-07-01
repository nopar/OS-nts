<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<?xml version="1.0" encoding="UTF-8" ?>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cor" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Pridaj štát</title>
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
        </cor:choose>    </head>
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
            <h1>Pridaj odberové miesto</h1>

            <cor:if  test="${!empty vyjazd}">
            <form:form method="POST" commandName="vyjazd" action="${pageContext.request.contextPath}/logged/lekar/vyjazd/add">
                <table>
                    <tbody>
                        <tr>
                            <td><form:input type="hidden" path="idVyjazdovyOdber"/></td>
                        </tr>
                        <tr>
                            <td>Názov:</td>
                            <td><form:input path="nazov" /></td>
                        </tr>
                        <tr>
                            <td>Dátum:</td>
                            <td><form:input path="datum" placeholder="01/08/2014 MM/DD/RRRR" /></td>
                        </tr>
                        <tr>
                            <td>Adresa:</td>
                            <td><form:input path="adresa" /></td>
                        </tr>
                        <tr>
                            <td>Čas začiatku:</td>
                            <td><form:input path="casZaciatku" placeholder="08:00:00" /></td>
                        </tr>
                        <tr>
                            <td>Čas konca:</td>
                            <td><form:input path="casKonca" placeholder="13:00:00" /></td>
                        </tr>
                        <tr>
                            <td>Popis:</td>
                            <td><form:input path="blizsiPopis" /></td>
                        </tr>
                        <tr>
                            <td>Kraj:</td>
                            <td>
                                <form:select path="idKraj.idKraj" >
                                    <cor:forEach items="${kraje}" var="kr">
                                        <option label="${kr.kraj}">${kr.idKraj}</option>
                                    </cor:forEach>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td>Lekár:</td>
                            <td>
                                <form:input path="idLekar.idUser" 
                                            required="true" 
                                            value="${lekar.idUser}"
                                            readonly="true"
                                            type="hidden"
                                            />
                                ${lekar.priezvisko} ${lekar.meno}
                            </td> 
                        </tr>
                        
                        
                        <tr>
                            <td><input type="submit" value="Add" /></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </form:form>
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