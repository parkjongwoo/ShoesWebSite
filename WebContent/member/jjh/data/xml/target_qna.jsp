<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>
<?xml version='1.0' encoding='UTF-8' ?>
<root>
	<c:if test="${!empty target_qna}">
		<c:forEach var = "qna" items = "${target_qna}" varStatus="idx">
		<qnas>
			<idx>${idx.count}</idx>
			<qid>${qna.qid}</qid>
			<qtitle>${qna.qtitle} </qtitle>
			<qcontent>${qna.qcontent}</qcontent>
			<qdate>${qna.qdate}</qdate>
			<mid>${qna.mid}</mid>
			<pid>${qna.pid}</pid>
		</qnas>
		</c:forEach>
	</c:if>
</root>
