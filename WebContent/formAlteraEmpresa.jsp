<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/alteraEmpresa" var="urlAlteraEmpresa" />
<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy" var="varDataAbertura" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Empresa</title>
</head>
<body>
	<form action="${ urlAlteraEmpresa }" method="post">
		<input type="hidden" name="id" value="${ empresa.id }" />
		Nome: <input type="text" name="nome" value="${ empresa.nome }" />
		Data Abertura: <input type="text" name="data" value="${ varDataAbertura }" />
		<button type="submit">Enviar</button>
	</form>
</body>
</html>