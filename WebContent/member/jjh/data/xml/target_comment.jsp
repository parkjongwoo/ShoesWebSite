<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>
<?xml version='1.0' encoding='UTF-8' ?>
<root>
	<c:if test="${!empty target_comment}">
		<c:forEach var = "comment" items = "${target_comment}" varStatus="idx">
		<comments>
			<idx>${idx.count}</idx>
			<cid>${comment.cid}</cid>
			<ctitle>${comment.ctitle}</ctitle>
			<ccontent>${comment.ccontent}</ccontent>
			<cdate>${comment.cdate}</cdate>
			<mname>${comment.mname}</mname>
		</comments>
		</c:forEach>
	</c:if>
</root>
