<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
{
	"result":
	{
		"success":${result},
		"msg":
		"<c:choose><c:when test="${result}">최근 배송주소 목록을 불러왔습니다.</c:when>
		<c:otherwise>최근 배송주소를 불러오는데 실패하였습니다.</c:otherwise></c:choose>",
		"data":
		[
			<c:forEach var="item" items="${addressRecentList}" varStatus="s">
			{
				"ddname":"${item.ddname}",
				"ddphone":"${item.ddphone}",
				"ddphone2":"${item.ddphone2}",
				"ddzipcode":"${item.ddzipcode}",
				"ddadress":"${item.ddadress}",
				"dda_detail":"${item.dda_detail}",
				"ddmsg":"${item.ddmsg}"
			}<c:if test="${!s.last}">,</c:if>	
			</c:forEach>
		]	
	}				
}