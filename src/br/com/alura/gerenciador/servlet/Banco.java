package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa(chaveSequencial++, "Alura");
		Empresa empresa2 = new Empresa(chaveSequencial++, "Caelum");
		Empresa empresa3 = new Empresa(chaveSequencial++, "Bradesco");
		lista.add(empresa);
		lista.add(empresa2);
		lista.add(empresa3);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}
	
	public void removeEmpresa(Integer id) {
		Empresa empresa = null;
		
		for(Empresa item: Banco.lista) {
			if(item.getId() == id) {
				empresa = item;
			}
		}
		
		lista.remove(empresa);
	
	}
	
	public Empresa buscaEmpresaPelaId(Integer id) {
		for(Empresa empresa: Banco.lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}
	
	public void alterarEmpresa(Integer id, String nome, Date dataAbertura) {
		for(Empresa empresa: Banco.lista) {
			if(empresa.getId() == id) {
				empresa.setNome(nome);
				empresa.setDataAbertura(dataAbertura);
			}
		}
	}
}

//Iterator<Empresa> it = lista.iterator();
//
//while(it.hasNext()) {
//	Empresa emp = it.next();
//	
//	if(emp.getId() == id) {
//		it.remove();
//	}
//}