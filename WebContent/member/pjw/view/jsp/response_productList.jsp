<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
{
	"list":[
		<c:forEach var="item" items="${productListNew}" varStatus="s">
		{
			"pid":"${item.pid}",
			"pname":"${item.pname}",
			"pimgurl":"${item.pimgurl}",
			"cname":"${item.cname}"
		}<c:if test="${!status.last}">,</c:if>		
		</c:forEach>		
	]	
}