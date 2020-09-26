<%-- 
    Document   : Viewbeer
    Created on : 14 Mar 2020, 10:50:01
    Author     : Brendan
--%>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Beer</title>
    </head>
    <body>
        <form action="/Assignment3/beer">

            <input type="submit" value="<spring:message code="button.back"/>"/>
        </form>
        <form action="/Assignment3/beer/chooseLocale">
        <select name="locale">
          <option value="en_IE"><spring:message code="language.english"/></option>
            <option value="es_ES"><spring:message code="language.spanish"/></option>

        </select>
         <input type="submit" value="<spring:message code="button.chooseLocale"/>"/>
    </form>

        <table style="width:100%">

            <tr>
                <td><spring:message code="label.id"/></td>
                <td>${beer.id}</td>
            </tr>
            <tr>
                <td><spring:message code="label.name"/></td>
                <td>${beer.name}</td>
            </tr>
            <tr>
                <td><spring:message code="label.abv"/></td>
                <td>${beer.abv}</td>
            </tr>
            <tr>
                <td><spring:message code="label.lastMod"/></td>
<fmt:formatDate value="${beer.lastMod}" />
<td>${beer.lastMod}</td>
            </tr>
            <tr>
                <td><spring:message code="label.description"/></td>
                <td>${beer.description}</td>
            </tr>
            <tr>
                <td><spring:message code="label.category"/></td>
                <td>${cat.catName}</td>
            </tr>
            <tr>
                <td><spring:message code="label.style"/></td>
                <td>${style.styleName}</td>
            </tr>
            <tr>
                <td><img src="Image/${beer.image}" width="50" height="50"></td>

            </tr> 
                  <tr>
                <td><spring:message code="label.buyPrice"/></td>
                 <fmt:formatNumber value = "${beer.buyPrice}" type = "currency"/>
                <td>${beer.buyPrice}</td>
            </tr>
            <tr>
                <td><spring:message code="label.sellPrice"/></td>
               <fmt:formatNumber value = "${beer.sellPrice}" type = "currency"/>
                <td>${beer.sellPrice}</td>
            </tr>
            
        </table>



        <table>
            <tr>
                <td><spring:message code="button.buyPercentIncrease"/></td>
                <td>
                    <form>
                        <input type="number" id="buyPercentIncrease">
                        <input type="button" value="<spring:message code="button.updatePrice"/>" onclick="CalculateIncreaseBuyPrice();" >
                    </form>
                </td>
            </tr>
            <tr>
                <td><spring:message code="button.sellPercentIncrease"/></td>
                <td>
                    <form>
                        <input type="number" id="sellPercentIncrease">
                        <input type="button" value="<spring:message code="button.updatePrice"/>" onclick="CalculateIncreaseSellPrice();" >
                    </form>
                </td>
            <form action="updatePrice">
                <table>
                    <tr>
                        <td><spring:message code="label.buyPrice"/></td>
                        <td><input type="text" name="buyPrice" id="buyPrice" value="${beer.buyPrice}"/></td>
                        <td style="color:red"><form:errors path="buyPrice"/> </td>
                    </tr>
                    <tr>
                        <td><spring:message code="label.sellPrice"/></td>
                        <td><input type="text" name="sellPrice" id="sellPrice" value="${beer.sellPrice}"/></td>
                        <td style="color:red"><form:errors path="sellPrice"/> </td>
                    </tr>

                    <tr>
                        <td><input type="hidden" name="id" value="${beer.id}"/></td>
                        <td><input type="submit" value="<spring:message code="button.savePrice"/>"</td>                
                    </tr>
                </table>
                <script>
                    function CalculateIncreaseBuyPrice()
                    {
                        var PercentIncrease = parseFloat(document.getElementById("buyPercentIncrease").value);
                        var BuyPrice = parseFloat(document.getElementById("buyPrice").value);

                        document.getElementById("buyPrice").value = BuyPrice + (BuyPrice / 100 * PercentIncrease);
                    }

                    function CalculateIncreaseSellPrice()
                    {
                        var PercentIncrease = parseFloat(document.getElementById("sellPercentIncrease").value);
                        var SellPrice = parseFloat(document.getElementById("sellPrice").value);

                        document.getElementById("sellPrice").value = SellPrice + (SellPrice / 100 * PercentIncrease);
                    }
                </script>
            </form>
        </tr>


</body>
</html>
