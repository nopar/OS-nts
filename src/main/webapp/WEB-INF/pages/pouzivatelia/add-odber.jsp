<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<?xml version="1.0" encoding="UTF-8" ?>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cor" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Pridaj odber</title>
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
            <h1>Pridaj odber</h1>
            
                             <script type="text/javascript">
                    window.onload = function () {
                        date=Date();
                        
                        var celydatum = new Date().toISOString().substring(0, 10);
                        var den = new Date().toISOString().substring(8, 10);
                        var mesiac = new Date().toISOString().substring(5, 7);
                        var rok = new Date().toISOString().substring(0, 4);
                        var moj = den+"/"+mesiac+"/"+rok;
document.getElementById("dat").value=moj;
//document.write(date);
                    }
                    
</script>
                </script>

            <cor:if  test="${!empty odber}">
            <form:form method="POST" commandName="odber" action="${pageContext.request.contextPath}/logged/lekar/user/add_odber">
                <table>
                    <tbody>
                        <tr>
                            <td><form:input type="hidden" path="idOdber" /></td>
                        </tr>
                        <tr>
                            <td>Dátum:</td>
                            <td><form:input path="datum" placeholder="11/11/2014" id="dat" required="true" maxlength="30"/></td>
                        </tr>
                        <tr>
                            <td>Objem:</td>
                            <td><form:input path="objem" type="number" required="true" maxlength="6"/></td>
                        </tr>
                        <tr>
                            <td>Poznámka:</td>
                            <td><form:input path="poznamka" /></td>
                        </tr>
                        <tr>
                            <td>Darca:</td>
                            <td>
                                <form:select path="idDarca.idUser" >
                                    <cor:forEach items="${pouzivatelia}" var="k">
                                        <option label="${k.priezvisko}">${k.idUser}</option>
                                    </cor:forEach>
                                </form:select>
                            </td>
                        </tr>   

                        
                        <tr>
                            <td>Lekár:</td>
                            <td>
                                <form:select path="idLekar.idUser" >
                                    <cor:forEach items="${pouzivatelia}" var="k">
                                        <option label="${k.priezvisko}">${k.idUser}</option>
                                    </cor:forEach>
                                </form:select>
                            </td>
                        </tr>            
                        <tr>
                            <td><input type="submit" value="Pridaj" /></td>
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