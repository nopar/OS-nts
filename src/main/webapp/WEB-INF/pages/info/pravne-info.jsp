    <%-- 
    Document   : pranve info
    Created on : 28-Apr-2014, 16:19:00
    Author     : nox
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cor" %>

<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Právne informácie</title>

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
                
        <script src="${pageContext.request.contextPath}/resources/js/geoLocation.js" type="text/javascript"></script> 
        
        <style>
            body > div > div > h2{
                color: #31708f;
            }
        </style>
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
            
            
        <cor:if  test="${!empty message}">                
            <h2>Message : ${message}</h2>	
        </cor:if>

        <br />
        <center>   
            <h1>Právne informácie</h1>
        </center>    
        
        <div id="middlebox_right_subpage">
            
            <h1 style="color: #00B4FF">Podmienky používania internetových stránok</h1>
            <p>Tieto podmienky používania internetových stránok Národnej transfúznej služby SR <strong>www.ntssr.sk</strong> (ďalej len ako „internetové stránky“) sú účinné odo dňa ich zverejnenia. Podmienky používania internetových stránok boli zverejnené dňa 1.1.2010.</p>
            <h2>1. Všeobecné ustanovenia</h2>
            <p>Podmienky využívania internetových stránok určuje Národná transfúzna služba SR, ako ich prevádzkovateľ, a je oprávnená ich kedykoľvek jednostranne meniť. Zmena Podmienok používania internetových stránok je účinná uverejnením zmenených Podmienok používania internetových stránok. Národná transfúzna služba SR je kedykoľvek oprávnená meniť a dopĺňať obsah informácií uverejnených na internetovej stránke ako i kedykoľvek prerušiť a/alebo prestať uverejňovať informácie bez toho, aby o tejto skutočnosti musela vopred informovať.</p>
            <h2>2. Autorské práva</h2>
            <p>Majiteľom a oprávneným užívateľom všetkých autorských práv k internetovej stránke, jej dizajnu, uverejneným obrázkom, zvukovým alebo obrazovo-zvukovým záznamom a textom je v zmysle zákona č. 618/2003 Z.z. o autorskom práve a právach súvisiacich s autorským právo (autorský zákon) v znení neskorších predpisov jej prevádzkovateľ Národná transfúzna služba SR. V prípade použitia časti textu alebo iných obrazových, zvukových alebo obrazovo-zvukových záznamov internetovej stránky po predchádzajúcom výslovnom písomnom súhlase prevádzkovateľa Národnej transfúznej služby SR sú tretie osoby povinné uviesť internetovú stránku <strong>www.ntssr.sk</strong> ako zdroj informácií. Majiteľom autorských práv k obrazovej ochrannej známke "NTS" je Národná transfúzna služba SR.</p>
            <h2>3. Zodpovednosť</h2>
            <p>Internetová stránka slúži výhradne na informačné a vzdelávacie účely o činnosti a poslaní Národnej transfúznej služby SR. Pripojenie na internetovú stránku je realizované výlučne na vlastné nebezpečenstvo užívateľa. Národná transfúzna služba SR nezodpovedá za správnosť a aktuálnosť tu uvedených informácií a ani za žiadnu škodu spôsobenú akýmkoľvek použitím internetových stránok a v nich uvedených informácií.</p>
            <h2>4. Ochrana osobných údajov</h2>
            <p>Podmienkou používania internetovej stránky nie je poskytnutie žiadnych osobných údajov. V prípade vyplnenia internetového formulára on-line poradne v časti "Otázky a odpovede" používateľ udeľuje Národnej transfúznej službe SR súhlas so spracovaním svojich osobných údajov v nasledovnom znení: "Zadaním otázky do internetového formulára on-line poradne v časti "Otázky a odpovede" udeľujem Národnej transfúznej službe SR, so sídlom Limbová 3, 833 14 Bratislava, IČO: 30 853 915, ako prevádzkovateľovi súhlas na spracovanie mojich osobných údajov v súlade s § 7 zákona č. 428/2002 Z.z. o ochrane osobných údajov v znení neskorších predpisov v rozsahu uvedenom vo vyplnenom formulári (meno, priezvisko a e-mailová adresa). Súhlas udeľujem najmä na to, aby prevádzkovateľ osobných údajov vyššie uvedené osobné údaje zbieral, zhromažďoval, zaznamenával, uchovával, usporadúval, vyhľadával a využíval, a to všetko za účelom prevádzkovania on-line poradne týkajúcej sa darovania krvi. Beriem na vedomie, že v súvislosti so spracúvaním osobných údajov mám práva uvedené v zákone č. 428/2002 Z.z. o ochrane osobných údajov v znení neskorších predpisov. Súhlas so spracovaním osobných údajov je udelený dobrovoľne, na dobu neurčitú a dotknutá osoba ho môže kedykoľvek písomne odvolať na adrese prevádzkovateľa."</p>
            <h2>5. Technické ustanovenia</h2>
            <p>Tretie osoby nie sú v žiadnom prípade oprávnené zasahovať do internetovej stránky, meniť ju a/alebo odstraňovať a meniť akékoľvek jej súčasti. V prípade porušenia tohto ustanovenia má Národná transfúzna služba SR nárok na náhradu spôsobenej škody. Tretie osoby nie sú oprávnené zahlcovať internetovú stránku viacerými súčasnými požiadavkami o prístup, ktoré by mohli spôsobiť jej znefunkčnenie (flooding). V prípade porušenia tohto ustanovenia má Národná transfúzna služba SR nárok na náhradu spôsobenej škody.</p>
            <h2>6. Údaje o prevádzkovateľovi internetovej stránky</h2>
            <table style="padding: 0px;" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                    <tr valign="top">
                        <td style="border: 0px; line-height: 18px; padding: 0px;"><strong>Názov:</strong></td>
                        <td style="border: 0px; line-height: 18px;">Národná transfúzna služba SR</td>
                    </tr>
                    <tr valign="top">
                        <td style="border: 0px; line-height: 18px; padding: 0px;"><strong>Sídlo:</strong></td>
                        <td style="border: 0px; line-height: 18px;">Ďumbierska 3/L, 831 01 Bratislava</td>
                    </tr>
                    <tr valign="top">
                        <td style="border: 0px; line-height: 18px; padding: 0px;"><strong>IČO:</strong></td>
                        <td style="border: 0px; line-height: 18px;">30 853 915</td>
                    </tr>
                    <tr valign="top">
                        <td style="border: 0px; line-height: 18px; padding: 0px;"><strong>DIČ:</strong></td>
                        <td style="border: 0px; line-height: 18px;">2021764371</td>
                    </tr>
                    <tr valign="top">
                        <td style="border: 0px; line-height: 18px; padding: 0px;"><strong>&nbsp;</strong></td>
                        <td style="border: 0px; line-height: 18px;">&nbsp;</td>
                    </tr>
                </tbody>
            </table>
            <p>&nbsp;</p>
            <p>Národná transfúzna služba SR bola zriadená Zriaďovacou listinou Ministerstva zdravotníctva SR číslo 003775-4/2003 zo dňa 02.12.2003.</p> <div class="clearline"></div>
        </div>

        

        <p id="x"></p><br>
        <div id="mapholder"></div>
        </div>
    </body>
</html>
