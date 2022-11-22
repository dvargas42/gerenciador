<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/removeEmpresa" var="urlRemoveEmpresa"/>
<c:url value="/mostraEmpresa" var="urlMostraEmpresa"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lista de Empresas</title>
</head>
<body>
	<c:if test="${ not empty empresa }">
		Empresa ${ empresa } cadastrada com sucesso!
	</c:if>
	
	<p>Lista deEmpresas: </p>
	<ul>
		<c:forEach var="empresa" items="${ empresas }">
			<li>
				${ empresa.nome } - <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy" />
				<a href="${ urlMostraEmpresa }">editar</a>
				<a href="${ urlRemoveEmpresa }">remover</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>