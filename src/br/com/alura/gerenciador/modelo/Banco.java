package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa(chaveSequencial++, "Alura");
		Empresa empresa2 = new Empresa(chaveSequencial++, "Caelum");
		Empresa empresa3 = new Empresa(chaveSequencial++, "Bradesco");
		
		lista.add(empresa);
		lista.add(empresa2);
		lista.add(empresa3);
		
		Usuario u1 = new Usuario();
		u1.setLogin("nico");
		u1.setSenha("12345");
		
		Usuario u2 = new Usuario();
		u2.setLogin("daniel");
		u2.setSenha("12345");
		
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
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
	
	public void alteraEmpresa(Empresa emp) {
		for(Empresa empresa: Banco.lista) {
			if(empresa.getId() == emp.getId()) {
				empresa.setNome(emp.getNome());
				empresa.setDataAbertura(emp.getDataAbertura());
			}
		}
	}

	public Usuario existeUsuario(String login, String senha) {
		for(Usuario usuario: listaUsuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
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