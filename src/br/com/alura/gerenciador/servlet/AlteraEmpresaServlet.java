package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

//@WebServlet(urlPatterns = "/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Alterando empresa");
		
		String nome = request.getParameter("nome");
		String paramData = request.getParameter("data");
		String paramId = request.getParameter("id");
		
		Integer id = Integer.valueOf(paramId);
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramData);
		} catch (ParseException e){
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa(id, nome, dataAbertura);
		Banco banco = new Banco();
		banco.alteraEmpresa(empresa);
		
		response.sendRedirect("listaEmpresas");		
	}
}
