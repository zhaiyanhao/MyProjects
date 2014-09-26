<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
	<title>Mojoping | Checklists</title>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">		
	
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	
	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="<c:url value="/resources/js/jquery.autocomplete.min.js" />"></script>
	<link href="<c:url value="/resources/css/checklists.css" />" rel="stylesheet">
	
	<script type="text/javascript" src="<c:url value="/resources/js/header.js" />"> </script>
	<script type="text/javascript" src="<c:url value="/resources/js/checklists.js" />"> </script>
</head>
<body class="main-body">
	<div id="container" class="main-container">
		<div class="header" id="header"></div>
<div class="frameIn">
<div id="check_list">
		<h> Checklist:</h><br>
		<c:forEach var="i" items="${checkList}">
		<div id="single_list" style="padding-top:20px;">
        Title:<c:out value="${i.title}"/><p>
        Keywords: <c:out value="${i.keywords}"/>
        Info:<c:out value="${i.brief_info}"/><p>
        	<h> Procedure:</h><br>
		<c:forEach var="p" items="${procedureList}">
		<c:if test="${ i.checklist_id == p.checklist_id}" >
        Procedure title:<c:out value="${p.step_title}"/><p>
        Procedure detail:<c:out value="${p.step_details}"/><p>
        Procedure video url:<c:out value="${p.tutoriol_video_url}"/><p>
        </c:if>
		</c:forEach>
		
		    	<h> Material:</h><br>
		<c:forEach var="m" items="${materialList}">
		<c:if test="${ m.procedure_id ==  i.checklist_id}" >
        Material name:<c:out value="${m.material_name}"/><p>
        Material coverage:<c:out value="${m.coverage}"/><p>
        Material quantity:<c:out value="${m.quantity}"/><p>
        </c:if>
		</c:forEach>
		
			    	<h> Labor:</h><br>
		<c:forEach var="la" items="${laborList}">
		<c:if test="${ la.procedure_id == i.checklist_id}" >
        Task name:<c:out value="${la.labor_task}"/><p>
        Number of People:<c:out value="${la.labor_num_people}"/><p>
        Number of Hour:<c:out value="${la.labor_num_hour}"/><p>
        Hourly Cost:<c:out value="${la.labor_hourly_cost}"/><p>
        Labor Insurance:<c:out value="${la.labor_insurance}"/><p>
        Detail:<c:out value="${la.labor_detail}"/><p>
        </c:if>
		</c:forEach>
		
		
			    	<h> Overhead:</h><br>
		<c:forEach var="ov" items="${overheadList}">
		<c:if test="${ ov.procedure_id ==  i.checklist_id}" >
        Overhead Cost:<c:out value="${ov.overhead_cost}"/><p>
        Overhead Details:<c:out value="${ov.overhead_detail}"/><p>
        </c:if>
		</c:forEach>
		
					    	<h> Profit:</h><br>
		<c:forEach var="pro" items="${profitList}">
		<c:if test="${ pro.procedure_id ==  i.checklist_id}" >
        Profit Amount:<c:out value="${pro.profit_amount}"/><p>
        Profit Details:<c:out value="${pro.profit_detail}"/><p>
        </c:if>
		</c:forEach>
		
							    	<h> Garbage:</h><br>
		<c:forEach var="ga" items="${garbageList}">
		<c:if test="${ ga.procedure_id ==  i.checklist_id}" >
        Garbage Cost:<c:out value="${ga.garbage_cost}"/><p>
        Garbage Details:<c:out value="${ga.garbage_detail}"/><p>
        </c:if>
		</c:forEach>
		
		
		
									    	<h> Insurance:</h><br>
		<c:forEach var="in" items="${insuranceList}">
		<c:if test="${ ga.procedure_id ==  i.checklist_id}" >
        Insurance Amount:<c:out value="${in.insurance_amount}"/><p>
        Insurance Details:<c:out value="${in.insurance_detail}"/><p>
        </c:if>
		</c:forEach>
	
		 </div>
	    </c:forEach>
		
	
		</div>
</div>
		
	</div>
</body>
</html>