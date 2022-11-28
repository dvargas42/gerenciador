<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="urlEntradaServlet" />
<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy" var="varDataAbertura" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Empresa</title>
</head>
<body>
	<form action="${ urlEntradaServlet }" method="post">
		<input type="hidden" name="id" value="${ empresa.id }" />
		<input type="hidden" name="acao" value="AlteraEmpresa">
		Nome: <input type="text" name="nome" value="${ empresa.nome }" />
		Data Abertura: <input type="text" name="data" value="${ varDataAbertura }" />
		<button type="submit">Enviar</button>
	</form>
</body>
</html>