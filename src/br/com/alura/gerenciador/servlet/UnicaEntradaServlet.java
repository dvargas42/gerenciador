package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresaForm;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		System.out.println("Parametro "+ paramAcao);
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		
		String endereco;
		
		try {
			Class classe = Class.forName(nomeDaClasse); //carrega a classe com o nome
			Acao acao = (Acao) classe.newInstance();
			endereco = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String[] tipoRecurso = endereco.split(":");
		
		if(tipoRecurso[0].equals("forward")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/" + tipoRecurso[1]);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(tipoRecurso[1]);
		}
	}
}
		
//		String endereco = null;
		
//		if(paramAcao.equals("ListaEmpresas")) {
//			ListaEmpresas acao = new ListaEmpresas();
//			endereco = acao.executa(request, response);
//			
//		} else if(paramAcao.equals("RemoveEmpresa")) {
//			RemoveEmpresa acao = new RemoveEmpresa();
//			endereco = acao.executa(request, response);
//			
//		} else if(paramAcao.equals("MostraEmpresa")) {
//			MostraEmpresa acao = new MostraEmpresa();
//			endereco = acao.executa(request, response);
//			
//		} else if(paramAcao.equals("AlteraEmpresa")) {
//			AlteraEmpresa acao = new AlteraEmpresa();
//			endereco = acao.executa(request, response);
//	
//		} else if(paramAcao.equals("NovaEmpresa")) {
//			NovaEmpresa acao = new NovaEmpresa();
//			endereco = acao.executa(request, response);
//			
//		} else if(paramAcao.equals("NovaEmpresaForm")) {
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			endereco = acao.executa(request, response);
//		}
	
