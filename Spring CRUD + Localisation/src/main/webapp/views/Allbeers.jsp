<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <form action="/Assignment3/beer/search">
        <input type="text" name="searchName">
        <input type="submit" value="<spring:message code="label.search"/>">
    </form>
    

    <form action="/Assignment3/beer/chooseLocale">
        <select name="locale">
            <option value="en_IE"><spring:message code="language.english"/></option>
            <option value="es_ES"><spring:message code="language.spanish"/></option>

        </select>
        <input type="submit" value="<spring:message code="button.chooseLocale"/>"/>
    </form>
</head>
<table style="width:100%">
    <thead>
        <tr>

            <th align="left"><spring:message code="label.id"/></th>
            <th align="left"><spring:message code="label.name"/></th>
            <th align="left"><spring:message code="label.abv"/></th>
         <th align="left"><spring:message code="label.image"/></th>
            <th align="left"><spring:message code="label.action"/></th>

        </tr>
    </thead>
    <tbody>
        <c:forEach items="${beerList}" var="beer"> 
            <tr>
                <td>${beer.id}</td>
                <td>${beer.name}</td>
                <td>${beer.abv}</td>
                <td><img src="Image/${beer.image}" width="50" height="50"></td>
                
                <td>
                    <form action="/Assignment3/beer/viewBeer">
                        <input type="hidden" name="id" value="${beer.id}"/>
                        <input type="submit" value="<spring:message code="label.viewDetails"/>"/>
                    </form>
                </td>
                
            </tr>
        </c:forEach>
    </tbody>
</table>
</html>
