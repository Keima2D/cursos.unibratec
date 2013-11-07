package concurso.negocio;

import java.util.List;

import concurso.basicas.Funcionario;
import concurso.basicas.Setor;
import concurso.dados.FuncionarioDAO;
import concurso.dados.IFuncionarioDAO;
import concurso.dados.ISetorDAO;
import concurso.dados.SetorDAO;

public class Controlador {
	private ISetorDAO setorDAO;
	private IFuncionarioDAO funcionarioDAO;
	
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
	
	public void inserir (Funcionario obj) {
		this.funcionarioDAO.inserir(obj);
	}

	public void alterar (Funcionario obj) {
		this.funcionarioDAO.alterar(obj);
	}
	
	public void remover (Funcionario obj) {
		this.funcionarioDAO.remover(obj);
	}

}