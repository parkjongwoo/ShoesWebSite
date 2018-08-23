<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>
<?xml version='1.0' encoding='UTF-8' ?>
<root>
	<c:if test="${!empty target_product}">
		<pname>${target_product.pname}</pname>
		<pimg_url>${target_product.pimg_url}</pimg_url>
		<poption>${target_product.poption}</poption>
		<phome>${target_product.phome}</phome>
		<pdcharge>${target_product.pdcharge}</pdcharge>
		<pprice>${target_product.pprice}</pprice>
		<pdescription>${target_product.pdescription}</pdescription>
	</c:if>
</root>
