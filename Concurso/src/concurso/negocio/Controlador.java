package concurso.negocio;

import java.util.List;

import concurso.basicas.Cargo;
import concurso.basicas.Funcionario;
import concurso.basicas.Setor;
import concurso.dados.FuncionarioDAO;
import concurso.dados.ICargoDAO;
import concurso.dados.IFuncionarioDAO;
import concurso.dados.ISetorDAO;
import concurso.dados.SetorDAO;

public class Controlador {
	private ISetorDAO setorDAO;
	private IFuncionarioDAO funcionarioDAO;
	private ICargoDAO cargoDAO;
	
	public Controlador () {
		this.setorDAO = new SetorDAO();
		this.funcionarioDAO = new FuncionarioDAO();
	}
	
	/**
	 * Setores
	 */ 
	
	public List<Setor> consultarTodosSetores () {
		return this.setorDAO.consultarTodos();
	}
	
	public void inserir (Setor obj) {
		this.setorDAO.inserir(obj);
	}

	public void alterar (Setor obj) {
		this.setorDAO.alterar(obj);
	}
	
	public void remover (Setor obj) throws NegocioException {
		
		List<Funcionario> resultado = funcionarioDAO.pesquisarFuncionarioPorSetor(obj);

		if (resultado.isEmpty()){
			this.setorDAO.remover(obj);	
		} else {
			throw new NegocioException("Existem funcionários cadastrados com este setor");
		}
	}	
	
	/**
	 * Funcionarios
	 */ 
	
	public List<Funcionario> consultarTodosFuncionarios () {
		return this.funcionarioDAO.consultarTodos();
	}
	
	public void inserir (Funcionario obj) {
		this.funcionarioDAO.inserir(obj);
	}

	public void alterar (Funcionario obj) {
		this.funcionarioDAO.alterar(obj);
	}
	
	public void remover (Funcionario obj)  throws NegocioException {
		try {
			this.funcionarioDAO.remover(obj);
		} catch (Exception e) {
			throw new NegocioException("");
		}
	}
	
	/**
	 * Cargos
	 */ 
	
	public void inserir (Cargo obj) {
		this.cargoDAO.inserir(obj);
	}

	public void alterar (Cargo obj) {
		this.cargoDAO.alterar(obj);
	}
	
	public void remover (Cargo obj) {
		this.cargoDAO.remover(obj);
	}
	public List<Cargo> consultarTodosCargos () {
		return this.cargoDAO.consultarTodos();
	}
	


}
