<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<?xml version="1.0" encoding="UTF-8"?>
<items>
<c:forEach var="noticeVO" items="${list}" begin="0" varStatus="status">
	<item>	
		<nid>${noticeVO.nid}</nid>
		<ntitle>${noticeVO.ntitle}</ntitle>
		<ncontent>${noticeVO.ncontent}</ncontent>
		<ndate>${noticeVO.ndate}</ndate>
		<nhit>${noticeVO.nhit}</nhit>
		<mid>${noticeVO.mid}</mid>
	</item>
</c:forEach>
<hit>
	<nhit>${nhit }</nhit>
</hit>
</items>
