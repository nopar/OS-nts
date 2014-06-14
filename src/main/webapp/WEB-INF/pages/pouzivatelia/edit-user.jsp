<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="UTF-8" ?>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cor" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Editácia</title>
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
                <h1>Editácia</h1>

                <p>${message}</p>
 <!--type="hidden"-->
            <form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/logged/lekar/user/edit/${user.idUser}.html">
                <table>
                    <tbody>
                        <tr>
                            <td>idUser</td>
                            <td><form:input path="idUser" readonly="true"/></td>
                        </tr>
                        <tr>
                            <td>email</td>
                            <td><form:input path="email" /></td>
                        </tr>
                        <tr>
                            <td>nick</td>
                            <td><form:input path="nick" /></td>
                        </tr>
                        <tr>
                            <td>password</td>
                            <td><form:input path="password" /></td>
                        </tr>
                        <tr>
                            <td>meno</td>
                            <td><form:input path="meno" /></td>
                        </tr>
                        <tr>
                            <td>priezvisko</td>
                            <td><form:input path="priezvisko" /></td>
                        </tr>
                        
                        
                        <tr>
                            <td>datumNarodenia</td>
                            <td><form:input path="datumNarodenia" /></td>
                        </tr>
                        <tr>
                            <td>telKontakt</td>
                            <td><form:input path="telKontakt" /></td>
                        </tr>
                        <tr>
                            <td>pohlavie</td>
                            <td><form:input path="pohlavie" /></td>
                        </tr>
                        <tr>
                            <td>enabed</td>
                            <td><form:input path="enabled" /></td>
                        </tr>
                        <tr>
                            <td>resetPasswd</td>
                            <td><form:input path="resetPasswd" /></td>
                        </tr>
                        <tr>
                            
                            <td><form:input path="idNastavenie.idNastavenie" type="hidden" readonly="true"/>
                            </td>                           
                        </tr>
                        
                        <tr>
                            <td>typKrvi</td>
                             <td>
                                <form:select path="idKrvnaSkupina.idKrvnaSkupina" >
                                    <cor:forEach items="${krv}" var="k">
                                        <option label="${k.typKrvi}">${k.idKrvnaSkupina}</option>
                                     </cor:forEach>
                                </form:select>                                
                            </td>
                        </tr>
                            
                         <tr>
                            <td>mesto </td>
                            <td>
                                 <form:select path="idAdresa.idAdresa" >
                                    <cor:forEach items="${adresy}" var="a">
                                        <option label="${a.idMesto.mesto}">${a.idAdresa}</option>
                                     </cor:forEach>
                                </form:select> 
                               
                                   
                            </td>
                        </tr>
                        
                        <tr>
                            <td><input type="submit" value="Uložiť"/></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </form:form>

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