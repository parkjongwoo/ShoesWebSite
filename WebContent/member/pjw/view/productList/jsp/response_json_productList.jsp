<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
{
	"list":[
		<c:forEach var="item" items="${productList}" varStatus="s">
		{
			"pid":"${item.pid}",
			"pname":"${item.pname}",
			"pimgurl":"${item.pimgurl}",
			"cname":"${item.cname}",
			"pprice":"${item.pprice}",
			"quan":"${item.quan}",
			"pdate":"${item.pdate}"
		}<c:if test="${!s.last}">,</c:if>		
		</c:forEach>		
	]
}