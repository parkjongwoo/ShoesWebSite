<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
{
	"result":
	{
		"success":${result},
		"msg":"<c:choose><c:when test="${result}">변경되었습니다.</c:when><c:otherwise>실패하였습니다.</c:otherwise></c:choose>",
		"data":
		[
			<c:forEach var="item" items="${basketList}" varStatus="s">
			{
				"mid":"${item.mid}",
				"pid":"${item.pid}",
				"pname":"${item.pname}",
				"bquantity":"${item.bquantity}",
				"pdcharge":"${item.pdcharge}",
				"pprice":"${item.pprice}"
			}<c:if test="${!s.last}">,</c:if>	
			</c:forEach>
		]	
	}				
}