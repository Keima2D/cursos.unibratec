package concurso.negocio;

import java.util.List;

import concurso.basicas.Setor;
import concurso.dados.ISetorDAO;
import concurso.dados.SetorDAO;

public class Controlador {

	private ISetorDAO setorDAO;
	
	public Controlador () {
		this.setorDAO = new SetorDAO();
	}
	
	public List<Setor> consultarTodosSetores () {
		return this.setorDAO.consultarTodos();
	}
}
